package com.liquorstore.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "image_url", nullable = false, length = 150)
    private String imageUrl;

    // Foreign Key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    // Reverse relationship — products that use this as their main image
    @OneToMany(mappedBy = "productImage", fetch = FetchType.LAZY)
    private List<Product> mainImageProducts;

    // Constructors
    public ProductImage() {}

    public ProductImage(String imageUrl, Product product) {
        this.imageUrl = imageUrl;
        this.product = product;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public List<Product> getMainImageProducts() { return mainImageProducts; }
    public void setMainImageProducts(List<Product> mainImageProducts) { this.mainImageProducts = mainImageProducts; }

    @Override
    public String toString() {
        return "ProductImage{id=" + id + ", imageUrl='" + imageUrl + "'}";
    }
}
