package com.rmro.viva.dao;

import com.rmro.viva.entity.Role;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoleDAO {

    public Role getRoleById(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Role.class, id);
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public Role getRoleByName(String name){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Role> query = session.createQuery(
                    "from Role where name=:name", Role.class);
            query.setParameter("name", name);
            return query.uniqueResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Role> getAllRoles(){
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Role> query = session.createQuery("from Role", Role.class);
            return query.list();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
