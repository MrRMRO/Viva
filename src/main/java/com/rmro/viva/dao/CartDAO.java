package com.rmro.viva.dao;

import com.rmro.viva.entity.Cart;
import com.rmro.viva.entity.User;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class CartDAO {

    public Cart getById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Cart.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cart getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Cart> query = session.createQuery(
                "FROM Cart c WHERE c.user.id = :userId", Cart.class);
            query.setParameter("userId", user.getId());
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Cart getBySessionId(String sessionId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Cart> query = session.createQuery(
                "FROM Cart c WHERE c.sessionId = :sid", Cart.class);
            query.setParameter("sid", sessionId);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean save(Cart cart) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cart);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Cart cart) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cart);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Cart cart) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(cart);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
