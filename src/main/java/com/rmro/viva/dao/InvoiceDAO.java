package com.rmro.viva.dao;

import com.rmro.viva.entity.Invoice;
import com.rmro.viva.entity.Order;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class InvoiceDAO {

    public Invoice getByOrder(Order order) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery(
                "FROM Invoice i WHERE i.order = :order", Invoice.class)
                .setParameter("order", order)
                .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean save(Invoice invoice) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(invoice);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }
}
