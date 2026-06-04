package com.rmro.viva.service;

import com.rmro.viva.dao.*;
import com.rmro.viva.dto.*;
import com.rmro.viva.entity.*;
import com.rmro.viva.util.EmailUtil;
import org.hibernate.Session;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class OrderService {

    private final OrderDAO orderDAO;
    private final OrderItemDAO orderItemDAO;
    private final CartDAO cartDAO;
    private final CartItemDAO cartItemDAO;
    private final StockDAO stockDAO;
    private final AddressDAO addressDAO;
    private final InvoiceDAO invoiceDAO;
    private final ProductDAO productDAO;

    public OrderService() {
        this.orderDAO = new OrderDAO();
        this.orderItemDAO = new OrderItemDAO();
        this.cartDAO = new CartDAO();
        this.cartItemDAO = new CartItemDAO();
        this.stockDAO = new StockDAO();
        this.addressDAO = new AddressDAO();
        this.invoiceDAO = new InvoiceDAO();
        this.productDAO = new ProductDAO();
    }

    public OrderResponse checkout(User user, CheckoutRequest request) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();

            Cart cart = cartDAO.getByUser(user);
            if (cart == null) return null;

            List<CartItem> cartItems = cartItemDAO.getByCart(cart);
            if (cartItems.isEmpty()) return null;

            Address address;
            if (request.getAddressId() != null) {
                address = addressDAO.getById(request.getAddressId());
            } else {
                address = new Address();
                address.setLine1(request.getAddressLine1());
                address.setUser(user);

                Query<City> cityQ = session.createQuery("FROM City WHERE name = :name", City.class);
                cityQ.setParameter("name", request.getCity() != null ? request.getCity() : "Colombo");
                City city = cityQ.uniqueResult();
                if (city == null) {
                    city = new City();
                    city.setName(request.getCity() != null ? request.getCity() : "Colombo");
                    session.persist(city);
                    session.flush();
                }
                address.setCity(city);

                if (request.getCounty() != null) {
                    Query<County> countyQ = session.createQuery("FROM County WHERE name = :name", County.class);
                    countyQ.setParameter("name", request.getCounty());
                    County county = countyQ.uniqueResult();
                    if (county != null) {
                        address.setCounty(county);
                    }
                }

                Query<AddressType> typeQ = session.createQuery("FROM AddressType", AddressType.class);
                typeQ.setMaxResults(1);
                AddressType addrType = typeQ.uniqueResult();
                address.setAddressType(addrType);

                session.persist(address);
                session.flush();
            }
            if (address == null) return null;

            OrderStatus pendingStatus = getOrderStatusByName("PENDING");
            if (pendingStatus == null) return null;

            PaymentMethod paymentMethod;
            if (request.getPaymentMethodId() != null) {
                paymentMethod = getPaymentMethodById(request.getPaymentMethodId());
            } else {
                String pmName = request.getPaymentMethod() != null ? request.getPaymentMethod().toUpperCase() : "CREDIT_CARD";
                Query<PaymentMethod> pmQ = session.createQuery("FROM PaymentMethod WHERE name = :name", PaymentMethod.class);
                pmQ.setParameter("name", pmName);
                paymentMethod = pmQ.uniqueResult();
                if (paymentMethod == null) {
                    paymentMethod = getPaymentMethodById(3);
                }
            }
            if (paymentMethod == null) return null;

            PaymentStatus unpaidStatus = getPaymentStatusByName("UNPAID");
            if (unpaidStatus == null) return null;

            BigDecimal subtotal = BigDecimal.ZERO;
            for (CartItem item : cartItems) {
                Stock stock = stockDAO.getLatestByProduct(item.getProduct());
                if (stock != null) {
                    subtotal = subtotal.add(stock.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
                }
            }

            Order order = new Order();
            order.setOrderNumber("ORD-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
            order.setTotAmount(subtotal);
            order.setShippingFee(new BigDecimal("5.00"));
            order.setDiscountAmount(BigDecimal.ZERO);
            order.setOrderNote(request.getOrderNote());
            order.setCreatedAt(LocalDate.now());
            order.setUpdatedAt(LocalDate.now());
            order.setOrderStatus(pendingStatus);
            order.setPaymentMethod(paymentMethod);
            order.setPaymentStatus(unpaidStatus);
            order.setUser(user);
            order.setAddress(address);

            session.persist(order);
            session.flush();

            for (CartItem item : cartItems) {
                Stock stock = stockDAO.getLatestByProduct(item.getProduct());
                BigDecimal unitPrice = stock != null ? stock.getPrice() : BigDecimal.ZERO;

                OrderItem orderItem = new OrderItem();
                orderItem.setQuantity(item.getQuantity());
                orderItem.setUnitPrice(unitPrice);
                orderItem.setSubTotal(unitPrice.multiply(BigDecimal.valueOf(item.getQuantity())));
                orderItem.setOrder(order);
                orderItem.setProduct(item.getProduct());
                session.persist(orderItem);

                if (stock != null) {
                    Stock newStock = new Stock();
                    newStock.setQuantityChange(-item.getQuantity());
                    newStock.setPreviousQuantity(stock.getNewQuantity());
                    newStock.setNewQuantity(stock.getNewQuantity() - item.getQuantity());
                    newStock.setNote("Order " + order.getOrderNumber());
                    newStock.setPrice(stock.getPrice());
                    newStock.setCreatedAt(LocalDate.now());
                    newStock.setProduct(item.getProduct());
                    session.persist(newStock);
                }
            }

            Query<?> delQ = session.createQuery("DELETE FROM CartItem ci WHERE ci.cart = :cart");
            delQ.setParameter("cart", cart);
            delQ.executeUpdate();

            Invoice invoice = new Invoice();
            invoice.setInvoiceNumber("INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase());
            invoice.setDate(LocalDate.now());
            invoice.setOrder(order);
            session.persist(invoice);

            tx.commit();

            OrderResponse resp = toOrderResponse(order);

            session.close();

            try {
                EmailUtil.sendOrderConfirmation(user.getEmail(), order.getOrderNumber());
            } catch (Exception e) {
                e.printStackTrace();
            }

            return resp;
        } catch (Exception e) {
            if (tx != null) try { tx.rollback(); } catch (Exception ex) { ex.printStackTrace(); }
            e.printStackTrace();
            return null;
        } finally {
            if (session.isOpen()) session.close();
        }
    }

    public List<OrderResponse> getUserOrders(User user) {
        return orderDAO.getByUser(user).stream()
            .map(this::toOrderResponse).collect(Collectors.toList());
    }

    public OrderResponse getOrderById(Integer id) {
        Order order = orderDAO.getById(id);
        return order != null ? toOrderResponse(order) : null;
    }

    public List<OrderResponse> getAllOrders(int page, int size) {
        return orderDAO.getAll(page, size).stream()
            .map(this::toOrderResponse).collect(Collectors.toList());
    }

    public long countAllOrders() {
        return orderDAO.countAll();
    }

    public boolean updateOrderStatus(Integer orderId, Integer statusId) {
        Order order = orderDAO.getById(orderId);
        if (order == null) return false;

        OrderStatus status = new OrderStatus();
        status.setId(statusId);
        order.setOrderStatus(status);
        return orderDAO.update(order);
    }

    public byte[] generateInvoice(Integer orderId) {
        Order order = orderDAO.getById(orderId);
        if (order == null) return null;

        StringBuilder invoice = new StringBuilder();
        invoice.append("INVOICE\n");
        invoice.append("=======\n\n");
        invoice.append("Order: ").append(order.getOrderNumber()).append("\n");
        invoice.append("Date: ").append(order.getCreatedAt()).append("\n");
        invoice.append("Total: $").append(order.getTotAmount()).append("\n");

        return invoice.toString().getBytes();
    }

    private OrderStatus getOrderStatusByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<OrderStatus> q = session.createQuery("FROM OrderStatus WHERE name = :name", OrderStatus.class);
            q.setParameter("name", name);
            return q.uniqueResult();
        }
    }

    private PaymentStatus getPaymentStatusByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<PaymentStatus> q = session.createQuery("FROM PaymentStatus WHERE name = :name", PaymentStatus.class);
            q.setParameter("name", name);
            return q.uniqueResult();
        }
    }

    private PaymentMethod getPaymentMethodById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(PaymentMethod.class, id);
        }
    }

    private OrderResponse toOrderResponse(Order order) {
        OrderResponse resp = new OrderResponse();
        resp.setId(order.getId());
        resp.setOrderNumber(order.getOrderNumber());
        resp.setTotAmount(order.getTotAmount());
        resp.setShippingFee(order.getShippingFee());
        resp.setDiscountAmount(order.getDiscountAmount());
        resp.setOrderNote(order.getOrderNote());
        resp.setCreatedAt(order.getCreatedAt());
        resp.setOrderStatus(order.getOrderStatus() != null ? order.getOrderStatus().getName() : null);
        resp.setPaymentMethod(order.getPaymentMethod() != null ? order.getPaymentMethod().getName() : null);
        resp.setPaymentStatus(order.getPaymentStatus() != null ? order.getPaymentStatus().getName() : null);
        resp.setCustomerName(order.getUser() != null ? order.getUser().getfName() + " " + order.getUser().getlName() : null);

        List<OrderItem> items = orderItemDAO.getByOrder(order);
        resp.setItems(items.stream().map(item -> {
            OrderItemResponse oir = new OrderItemResponse();
            oir.setId(item.getId());
            oir.setProductName(item.getProduct() != null ? item.getProduct().getName() : null);
            oir.setQuantity(item.getQuantity());
            oir.setUnitPrice(item.getUnitPrice());
            oir.setSubTotal(item.getSubTotal());
            return oir;
        }).collect(Collectors.toList()));

        return resp;
    }
}
