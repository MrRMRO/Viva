package com.rmro.viva.dto;

import java.math.BigDecimal;

public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal alcoholPercentage;
    private String sku;
    private Integer brandId;
    private Integer categoryId;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal discount;
    private String imageUrl;
    private String attributeName;
    private String attributeValue;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getAlcoholPercentage() { return alcoholPercentage; }
    public void setAlcoholPercentage(BigDecimal alcoholPercentage) { this.alcoholPercentage = alcoholPercentage; }
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }
    public Integer getBrandId() { return brandId; }
    public void setBrandId(Integer brandId) { this.brandId = brandId; }
    public Integer getCategoryId() { return categoryId; }
    public void setCategoryId(Integer categoryId) { this.categoryId = categoryId; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getDiscount() { return discount; }
    public void setDiscount(BigDecimal discount) { this.discount = discount; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public String getAttributeName() { return attributeName; }
    public void setAttributeName(String attributeName) { this.attributeName = attributeName; }
    public String getAttributeValue() { return attributeValue; }
    public void setAttributeValue(String attributeValue) { this.attributeValue = attributeValue; }
}
