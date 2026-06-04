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

    @Column(name = "added_at")
    private LocalDate addedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    public Wishlist() {}

    public Wishlist(LocalDate addedAt, User user, Product product) {
        this.addedAt = addedAt;
        this.user = user;
        this.product = product;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getAddedAt() { return addedAt; }
    public void setAddedAt(LocalDate addedAt) { this.addedAt = addedAt; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    @Override
    public String toString() {
        return "Wishlist{id=" + id + ", addedAt=" + addedAt + ", userId=" + (user != null ? user.getId() : null) + "}";
    }
}
