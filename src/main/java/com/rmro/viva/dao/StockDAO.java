package com.rmro.viva.dao;

import com.rmro.viva.entity.Product;
import com.rmro.viva.entity.Stock;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StockDAO {

    public Stock getLatestByProduct(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Stock> query = session.createQuery(
                "FROM Stock s WHERE s.product = :product ORDER BY s.createdAt DESC", Stock.class);
            query.setParameter("product", product);
            query.setMaxResults(1);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Stock> getByProduct(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Stock> query = session.createQuery(
                "FROM Stock s WHERE s.product = :product ORDER BY s.createdAt DESC", Stock.class);
            query.setParameter("product", product);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public boolean save(Stock stock) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(stock);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
