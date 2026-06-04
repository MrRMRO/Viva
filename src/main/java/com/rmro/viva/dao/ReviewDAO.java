package com.rmro.viva.dao;

import com.rmro.viva.entity.Product;
import com.rmro.viva.entity.Review;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ReviewDAO {

    public Review getById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Review.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Review> getByProduct(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Review> query = session.createQuery(
                "FROM Review r WHERE r.product = :product ORDER BY r.id DESC", Review.class);
            query.setParameter("product", product);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public double getAverageRatingByProduct(Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Double> query = session.createQuery(
                "SELECT AVG(r.rating) FROM Review r WHERE r.product = :product", Double.class);
            query.setParameter("product", product);
            Double result = query.uniqueResult();
            return result != null ? result : 0.0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0.0;
        }
    }

    public boolean save(Review review) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(review);
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
            Review review = session.get(Review.class, id);
            if (review != null) session.remove(review);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
