package com.rmro.viva.service;

import com.rmro.viva.dao.CartDAO;
import com.rmro.viva.dao.CartItemDAO;
import com.rmro.viva.dao.ProductDAO;
import com.rmro.viva.dao.StockDAO;
import com.rmro.viva.dto.*;
import com.rmro.viva.entity.*;
import com.rmro.viva.util.SessionUtil;
import jakarta.servlet.http.HttpServletRequest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CartService {

    private final CartDAO cartDAO;
    private final CartItemDAO cartItemDAO;
    private final ProductDAO productDAO;
    private final StockDAO stockDAO;

    public CartService() {
        this.cartDAO = new CartDAO();
        this.cartItemDAO = new CartItemDAO();
        this.productDAO = new ProductDAO();
        this.stockDAO = new StockDAO();
    }

    public CartResponse getCart(User user, HttpServletRequest request) {
        Cart cart = findOrCreateCart(user, request);
        return toCartResponse(cart);
    }

    public CartResponse addItem(User user, CartItemRequest itemReq, HttpServletRequest request) {
        Cart cart = findOrCreateCart(user, request);

        Product product = productDAO.getById(itemReq.getProductId());
        if (product == null) return null;

        Stock stock = stockDAO.getLatestByProduct(product);
        if (stock == null || stock.getNewQuantity() < itemReq.getQuantity()) return null;

        CartItem existing = cartItemDAO.getByCartAndProduct(cart, product);
        if (existing != null) {
            existing.setQuantity(existing.getQuantity() + itemReq.getQuantity());
            cartItemDAO.update(existing);
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setQuantity(itemReq.getQuantity());
            cartItem.setAddedAt(LocalDate.now());
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItemDAO.save(cartItem);
        }

        cart.setUpdatedAt(LocalDate.now());
        cartDAO.update(cart);

        return toCartResponse(cart);
    }

    public CartResponse updateItem(User user, Integer itemId, Integer quantity, HttpServletRequest request) {
        Cart cart = findOrCreateCart(user, request);
        CartItem item = cartItemDAO.getById(itemId);
        if (item == null || !item.getCart().getId().equals(cart.getId())) return null;

        item.setQuantity(quantity);
        cartItemDAO.update(item);

        cart.setUpdatedAt(LocalDate.now());
        cartDAO.update(cart);

        return toCartResponse(cart);
    }

    public CartResponse removeItem(User user, Integer itemId, HttpServletRequest request) {
        Cart cart = findOrCreateCart(user, request);
        CartItem item = cartItemDAO.getById(itemId);
        if (item == null || !item.getCart().getId().equals(cart.getId())) return null;

        cartItemDAO.delete(item);
        cart.setUpdatedAt(LocalDate.now());
        cartDAO.update(cart);

        return toCartResponse(cart);
    }

    public CartResponse mergeCart(User user, String sessionId) {
        Cart sessionCart = cartDAO.getBySessionId(sessionId);
        if (sessionCart == null) return getCart(user, null);

        Cart userCart = cartDAO.getByUser(user);
        if (userCart == null) {
            sessionCart.setUser(user);
            sessionCart.setSessionId(null);
            cartDAO.update(sessionCart);
            return toCartResponse(sessionCart);
        }

        List<CartItem> sessionItems = cartItemDAO.getByCart(sessionCart);
        for (CartItem si : sessionItems) {
            CartItem existing = cartItemDAO.getByCartAndProduct(userCart, si.getProduct());
            if (existing != null) {
                existing.setQuantity(existing.getQuantity() + si.getQuantity());
                cartItemDAO.update(existing);
            } else {
                si.setCart(userCart);
                cartItemDAO.update(si);
            }
        }

        cartDAO.delete(sessionCart);
        return toCartResponse(userCart);
    }

    private Cart findOrCreateCart(User user, HttpServletRequest request) {
        if (user != null) {
            Cart cart = cartDAO.getByUser(user);
            if (cart != null) return cart;
            cart = new Cart();
            cart.setUser(user);
            cart.setCreatedAt(LocalDate.now());
            cart.setUpdatedAt(LocalDate.now());
            cartDAO.save(cart);
            return cart;
        } else if (request != null) {
            String sessionId = SessionUtil.getSessionId(request);
            Cart cart = cartDAO.getBySessionId(sessionId);
            if (cart != null) return cart;
            cart = new Cart();
            cart.setSessionId(sessionId);
            cart.setCreatedAt(LocalDate.now());
            cart.setUpdatedAt(LocalDate.now());
            cartDAO.save(cart);
            return cart;
        }
        throw new RuntimeException("Unable to find or create cart");
    }

    private CartResponse toCartResponse(Cart cart) {
        CartResponse resp = new CartResponse();
        resp.setId(cart.getId());

        List<CartItem> items = cartItemDAO.getByCart(cart);
        List<CartItemResponse> itemResponses = items.stream().map(item -> {
            CartItemResponse cir = new CartItemResponse();
            cir.setId(item.getId());
            cir.setProductId(item.getProduct().getId());
            cir.setProductName(item.getProduct().getName());
            cir.setQuantity(item.getQuantity());

            Stock stock = stockDAO.getLatestByProduct(item.getProduct());
            if (stock != null) {
                cir.setUnitPrice(stock.getPrice());
                cir.setSubTotal(stock.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }

            if (item.getProduct().getProductImage() != null) {
                cir.setProductImage(item.getProduct().getProductImage().getImageUrl());
            }
            return cir;
        }).collect(Collectors.toList());

        resp.setItems(itemResponses);
        resp.setTotalAmount(itemResponses.stream()
            .map(i -> i.getSubTotal() != null ? i.getSubTotal() : BigDecimal.ZERO)
            .reduce(BigDecimal.ZERO, BigDecimal::add));
        return resp;
    }
}
