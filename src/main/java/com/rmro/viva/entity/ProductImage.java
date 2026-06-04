package com.rmro.viva.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_image")
public class ProductImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @OneToMany(mappedBy = "productImage", fetch = FetchType.LAZY)
    private List<Product> mainImageProducts;

    public ProductImage() {}

    public ProductImage(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public List<Product> getMainImageProducts() { return mainImageProducts; }
    public void setMainImageProducts(List<Product> mainImageProducts) { this.mainImageProducts = mainImageProducts; }

    @Override
    public String toString() {
        return "ProductImage{id=" + id + ", imageUrl='" + imageUrl + "'}";
    }
}
