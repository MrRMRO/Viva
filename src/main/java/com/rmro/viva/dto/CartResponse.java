package com.rmro.viva.dto;

import java.math.BigDecimal;
import java.util.List;

public class CartResponse {
    private Integer id;
    private List<CartItemResponse> items;
    private BigDecimal totalAmount;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public List<CartItemResponse> getItems() { return items; }
    public void setItems(List<CartItemResponse> items) { this.items = items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
}
