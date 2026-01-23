package com.rmro.viva.dao;

import com.rmro.viva.entity.User;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class UserDAO {

    public boolean saveUser(User user) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            return true;
        }catch(Exception ex) {
            if (transaction != null){
                transaction.rollback();
            }
            ex.printStackTrace();
            return false;
        }
    }

    public boolean isEmailExists(String email) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Long> query = session.createQuery("SELECT COUNT(u) from User u where u.email = :email", Long.class);
            query.setParameter("email", email);
            return query.uniqueResult() > 0;
        }catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
