package com.rmro.viva.dao;

import com.rmro.viva.entity.Order;
import com.rmro.viva.entity.User;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderDAO {

    public Order getById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> q = session.createQuery(
                "FROM Order o JOIN FETCH o.orderStatus JOIN FETCH o.paymentMethod JOIN FETCH o.paymentStatus JOIN FETCH o.user WHERE o.id = :id", Order.class);
            q.setParameter("id", id);
            return q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Order getByOrderNumber(String orderNumber) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery(
                "FROM Order o JOIN FETCH o.orderStatus JOIN FETCH o.paymentMethod JOIN FETCH o.paymentStatus JOIN FETCH o.user WHERE o.orderNumber = :on", Order.class);
            query.setParameter("on", orderNumber);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> getByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery(
                "FROM Order o JOIN FETCH o.orderStatus JOIN FETCH o.paymentMethod JOIN FETCH o.paymentStatus JOIN FETCH o.user WHERE o.user = :user ORDER BY o.createdAt DESC", Order.class);
            query.setParameter("user", user);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public List<Order> getAll(int page, int size) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Order> query = session.createQuery(
                "FROM Order o JOIN FETCH o.orderStatus JOIN FETCH o.paymentMethod JOIN FETCH o.paymentStatus JOIN FETCH o.user ORDER BY o.createdAt DESC", Order.class);
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
            Query<Long> query = session.createQuery("SELECT COUNT(o) FROM Order o", Long.class);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public long countByUser(User user) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery(
                "SELECT COUNT(o) FROM Order o WHERE o.user = :user", Long.class);
            query.setParameter("user", user);
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean save(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(order);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Order order) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(order);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
