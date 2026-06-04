package com.rmro.viva.dao;

import com.rmro.viva.entity.Product;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.math.BigDecimal;
import java.util.List;

public class ProductDAO {

    public Product getById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery(
                "FROM Product p JOIN FETCH p.brand JOIN FETCH p.category LEFT JOIN FETCH p.productImage WHERE p.id = :id", Product.class);
            query.setParameter("id", id);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Product> getAll(int page, int size, String sortBy, String sortDir) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Product p JOIN FETCH p.brand JOIN FETCH p.category LEFT JOIN FETCH p.productImage ORDER BY p." + sortBy + " " + sortDir;
            Query<Product> query = session.createQuery(hql, Product.class);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public long countAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(p) FROM Product p", Long.class);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Product> searchByName(String queryStr, int page, int size) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Product> query = session.createQuery(
                "FROM Product p JOIN FETCH p.brand JOIN FETCH p.category LEFT JOIN FETCH p.productImage WHERE LOWER(p.name) LIKE :q OR LOWER(p.description) LIKE :q", Product.class);
            query.setParameter("q", "%" + queryStr.toLowerCase() + "%");
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public long countSearch(String queryStr) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE LOWER(p.name) LIKE :q OR LOWER(p.description) LIKE :q", Long.class);
            query.setParameter("q", "%" + queryStr.toLowerCase() + "%");
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Product> filter(Integer categoryId, Integer brandId, BigDecimal minPrice, BigDecimal maxPrice, int page, int size) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder hql = new StringBuilder("SELECT DISTINCT p FROM Product p JOIN FETCH p.brand JOIN FETCH p.category LEFT JOIN FETCH p.productImage WHERE 1=1");
            if (categoryId != null) hql.append(" AND p.category.id = :catId");
            if (brandId != null) hql.append(" AND p.brand.id = :brandId");
            if (minPrice != null) hql.append(" AND EXISTS (FROM Stock s WHERE s.product = p AND s.price >= :minP)");
            if (maxPrice != null) hql.append(" AND EXISTS (FROM Stock s WHERE s.product = p AND s.price <= :maxP)");
            hql.append(" ORDER BY p.name");

            Query<Product> query = session.createQuery(hql.toString(), Product.class);
            if (categoryId != null) query.setParameter("catId", categoryId);
            if (brandId != null) query.setParameter("brandId", brandId);
            if (minPrice != null) query.setParameter("minP", minPrice);
            if (maxPrice != null) query.setParameter("maxP", maxPrice);
            query.setFirstResult(page * size);
            query.setMaxResults(size);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public long countFilter(Integer categoryId, Integer brandId, BigDecimal minPrice, BigDecimal maxPrice) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            StringBuilder hql = new StringBuilder("SELECT COUNT(p) FROM Product p WHERE 1=1");
            if (categoryId != null) hql.append(" AND p.category.id = :catId");
            if (brandId != null) hql.append(" AND p.brand.id = :brandId");
            if (minPrice != null) hql.append(" AND EXISTS (FROM Stock s WHERE s.product = p AND s.price >= :minP)");
            if (maxPrice != null) hql.append(" AND EXISTS (FROM Stock s WHERE s.product = p AND s.price <= :maxP)");

            Query<Long> query = session.createQuery(hql.toString(), Long.class);
            if (categoryId != null) query.setParameter("catId", categoryId);
            if (brandId != null) query.setParameter("brandId", brandId);
            if (minPrice != null) query.setParameter("minP", minPrice);
            if (maxPrice != null) query.setParameter("maxP", maxPrice);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean save(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Integer id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Product product = session.get(Product.class, id);
            if (product != null) {
                session.remove(product);
            }
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public Integer getMaxId() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Integer> query = session.createQuery(
                "SELECT COALESCE(MAX(p.id), 0) FROM Product p", Integer.class);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isSkuExists(String sku) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                "SELECT COUNT(p) FROM Product p WHERE p.sku = :sku", Long.class);
            query.setParameter("sku", sku);
            return query.uniqueResult() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
