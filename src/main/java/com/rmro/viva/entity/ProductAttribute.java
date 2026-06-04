package com.liquorstore.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "product_attribute")
public class ProductAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @Column(name = "value", nullable = false, length = 45)
    private String value;

    // Relationships
    @OneToMany(mappedBy = "productAttribute", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Product> products;

    // Constructors
    public ProductAttribute() {}

    public ProductAttribute(String name, String value) {
        this.name = name;
        this.value = value;
    }

    // Getters & Setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    @Override
    public String toString() {
        return "ProductAttribute{id=" + id + ", name='" + name + "', value='" + value + "'}";
    }
}
