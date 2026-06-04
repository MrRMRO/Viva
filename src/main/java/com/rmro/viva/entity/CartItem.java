package com.rmro.viva.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "cart_items")
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "added_at")
    private LocalDate addedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;

    public CartItem() {}

    public CartItem(Integer quantity, LocalDate addedAt, Product product, Cart cart) {
        this.quantity = quantity;
        this.addedAt = addedAt;
        this.product = product;
        this.cart = cart;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public LocalDate getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDate addedAt) { this.addedAt = addedAt; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public Cart getCart() { return cart; }
    public void setCart(Cart cart) { this.cart = cart; }

    @Override
    public String toString() {
        return "CartItem{id=" + id + ", quantity=" + quantity + "}";
    }
}
