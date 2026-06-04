package com.rmro.viva.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class OrderResponse {
    private Integer id;
    private String orderNumber;
    private BigDecimal totAmount;
    private BigDecimal shippingFee;
    private BigDecimal discountAmount;
    private String orderNote;
    private LocalDate createdAt;
    private String orderStatus;
    private String paymentMethod;
    private String paymentStatus;
    private String customerName;
    private List<OrderItemResponse> items;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getOrderNumber() { return orderNumber; }
    public void setOrderNumber(String orderNumber) { this.orderNumber = orderNumber; }
    public BigDecimal getTotAmount() { return totAmount; }
    public void setTotAmount(BigDecimal totAmount) { this.totAmount = totAmount; }
    public BigDecimal getShippingFee() { return shippingFee; }
    public void setShippingFee(BigDecimal shippingFee) { this.shippingFee = shippingFee; }
    public BigDecimal getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(BigDecimal discountAmount) { this.discountAmount = discountAmount; }
    public String getOrderNote() { return orderNote; }
    public void setOrderNote(String orderNote) { this.orderNote = orderNote; }
    public LocalDate getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDate createdAt) { this.createdAt = createdAt; }
    public String getOrderStatus() { return orderStatus; }
    public void setOrderStatus(String orderStatus) { this.orderStatus = orderStatus; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public List<OrderItemResponse> getItems() { return items; }
    public void setItems(List<OrderItemResponse> items) { this.items = items; }
}
