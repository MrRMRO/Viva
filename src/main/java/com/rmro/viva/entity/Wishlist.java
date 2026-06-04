package com.rmro.viva.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wishlist")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "added_at", nullable = false)
    private LocalDate addedAt;

    // Foreign Keys
    @Column(name = "user_id", nullable = false)
    private Integer userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Constructors
    public Wishlist() {}

    public Wishlist(LocalDate addedAt, Integer userId, Product product) {
        this.addedAt = addedAt;
        this.userId = userId;
        this.product = product;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDate addedAt) { this.addedAt = addedAt; }

    public Integer getUserId() { return userId; }
    public void setUserId(Integer userId) { this.userId = userId; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Wishlist{id=" + id + ", addedAt=" + addedAt + ", userId=" + userId + "}";
    }
}
