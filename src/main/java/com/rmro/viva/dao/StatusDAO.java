package com.rmro.viva.dao;

import com.rmro.viva.entity.Status;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StatusDAO {

    public Status getStatusById(Integer id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Status.class, id);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public Status getStatusByName(String name){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Status> query = session.createQuery(
                    "FROM Status WHERE name = :name", Status.class);
            query.setParameter("name", name);
            return query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Status> getAllStatus(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Status> query = session.createQuery("FROM Status", Status.class);
            return query.list();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
