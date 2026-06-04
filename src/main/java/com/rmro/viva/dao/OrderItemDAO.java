package com.rmro.viva.dao;

import com.rmro.viva.entity.Order;
import com.rmro.viva.entity.OrderItem;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class OrderItemDAO {

    public List<OrderItem> getByOrder(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<OrderItem> query = session.createQuery(
                "FROM OrderItem oi JOIN FETCH oi.product LEFT JOIN FETCH oi.product.productImage WHERE oi.order = :order", OrderItem.class);
            query.setParameter("order", order);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public boolean save(OrderItem orderItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(orderItem);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
