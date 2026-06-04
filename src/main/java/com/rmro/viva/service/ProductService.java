package com.rmro.viva.service;

import com.rmro.viva.dao.*;
import com.rmro.viva.dto.ProductRequest;
import com.rmro.viva.dto.ProductResponse;
import com.rmro.viva.entity.*;
import com.rmro.viva.util.FileUtil;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {

    private final ProductDAO productDAO;
    private final CategoryDAO categoryDAO;
    private final BrandDAO brandDAO;
    private final StockDAO stockDAO;
    private final ReviewDAO reviewDAO;

    public ProductService() {
        this.productDAO = new ProductDAO();
        this.categoryDAO = new CategoryDAO();
        this.brandDAO = new BrandDAO();
        this.stockDAO = new StockDAO();
        this.reviewDAO = new ReviewDAO();
    }

    public List<ProductResponse> getAll(int page, int size, String sortBy, String sortDir) {
        if (sortBy == null || sortBy.isEmpty()) sortBy = "name";
        if (sortDir == null || sortDir.isEmpty()) sortDir = "asc";

        List<Product> products = productDAO.getAll(page, size, sortBy, sortDir);
        return products.stream().map(this::toResponse).collect(Collectors.toList());
    }

    public long countAll() {
        return productDAO.countAll();
    }

    public ProductResponse getById(Integer id) {
        Product product = productDAO.getById(id);
        return product != null ? toResponse(product) : null;
    }

    public List<ProductResponse> search(String query, int page, int size) {
        return productDAO.searchByName(query, page, size).stream()
            .map(this::toResponse).collect(Collectors.toList());
    }

    public long countSearch(String query) {
        return productDAO.countSearch(query);
    }

    public List<ProductResponse> filter(Integer categoryId, Integer brandId,
                                         BigDecimal minPrice, BigDecimal maxPrice,
                                         int page, int size) {
        return productDAO.filter(categoryId, brandId, minPrice, maxPrice, page, size).stream()
            .map(this::toResponse).collect(Collectors.toList());
    }

    public long countFilter(Integer categoryId, Integer brandId,
                             BigDecimal minPrice, BigDecimal maxPrice) {
        return productDAO.countFilter(categoryId, brandId, minPrice, maxPrice);
    }

    public boolean create(ProductRequest request) {
        if (productDAO.isSkuExists(request.getSku())) return false;

        Brand brand = brandDAO.getById(request.getBrandId());
        Category category = categoryDAO.getById(request.getCategoryId());
        if (brand == null || category == null) return false;

        Integer nextId = productDAO.getMaxId() + 1;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            ProductImage img = new ProductImage();
            img.setImageUrl(request.getImageUrl());
            session.persist(img);

            ProductAttribute attr = new ProductAttribute();
            attr.setName(request.getAttributeName());
            attr.setValue(request.getAttributeValue());
            session.persist(attr);

            Product product = new Product(nextId, request.getName(), request.getDescription(),
                request.getAlcoholPercentage(), request.getSku(), brand, category);
            product.setProductImage(img);
            product.setProductAttribute(attr);
            session.persist(product);
            session.flush();

            Stock stock = new Stock();
            stock.setQuantityChange(request.getQuantity() != null ? request.getQuantity() : 0);
            stock.setPreviousQuantity(0);
            stock.setNewQuantity(request.getQuantity() != null ? request.getQuantity() : 0);
            stock.setPrice(request.getPrice());
            stock.setDiscount(request.getDiscount());
            stock.setNote("Initial stock entry");
            stock.setCreatedAt(LocalDate.now());
            stock.setProduct(product);
            session.persist(stock);

            tx.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Integer id, ProductRequest request) {
        Product product = productDAO.getById(id);
        if (product == null) return false;

        if (request.getName() != null) product.setName(request.getName());
        if (request.getDescription() != null) product.setDescription(request.getDescription());
        if (request.getAlcoholPercentage() != null) product.setAlcoholPercentage(request.getAlcoholPercentage());
        if (request.getSku() != null) product.setSku(request.getSku());
        if (request.getBrandId() != null) {
            Brand brand = brandDAO.getById(request.getBrandId());
            if (brand != null) product.setBrand(brand);
        }
        if (request.getCategoryId() != null) {
            Category category = categoryDAO.getById(request.getCategoryId());
            if (category != null) product.setCategory(category);
        }

        boolean updated = productDAO.update(product);

        if (updated && request.getPrice() != null) {
            Stock latestStock = stockDAO.getLatestByProduct(product);
            int currentQty = latestStock != null ? latestStock.getNewQuantity() : 0;

            Stock stock = new Stock();
            stock.setQuantityChange(request.getQuantity() != null ? request.getQuantity() - currentQty : 0);
            stock.setPreviousQuantity(currentQty);
            stock.setNewQuantity(request.getQuantity() != null ? request.getQuantity() : currentQty);
            stock.setPrice(request.getPrice());
            stock.setDiscount(request.getDiscount());
            stock.setNote("Stock update");
            stock.setCreatedAt(LocalDate.now());
            stock.setProduct(product);
            stockDAO.save(stock);
        }

        return updated;
    }

    public boolean delete(Integer id) {
        return productDAO.delete(id);
    }

    private ProductResponse toResponse(Product product) {
        ProductResponse resp = new ProductResponse();
        resp.setId(product.getId());
        resp.setName(product.getName());
        resp.setDescription(product.getDescription());
        resp.setAlcoholPercentage(product.getAlcoholPercentage());
        resp.setSku(product.getSku());
        resp.setBrandId(product.getBrand() != null ? product.getBrand().getId() : null);
        resp.setCategoryId(product.getCategory() != null ? product.getCategory().getId() : null);
        resp.setBrandName(product.getBrand() != null ? product.getBrand().getName() : null);
        resp.setCategoryName(product.getCategory() != null ? product.getCategory().getName() : null);

        if (product.getProductImage() != null) {
            resp.setImageUrl(product.getProductImage().getImageUrl());
        }

        Stock latestStock = stockDAO.getLatestByProduct(product);
        if (latestStock != null) {
            resp.setPrice(latestStock.getPrice());
            resp.setDiscount(latestStock.getDiscount());
            resp.setStockQuantity(latestStock.getNewQuantity());
        }

        resp.setAverageRating(reviewDAO.getAverageRatingByProduct(product));
        return resp;
    }
}
