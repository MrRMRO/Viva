package com.rmro.viva.dao;

import com.rmro.viva.entity.Cart;
import com.rmro.viva.entity.CartItem;
import com.rmro.viva.entity.Product;
import com.rmro.viva.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class CartItemDAO {

    public CartItem getById(Integer id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(CartItem.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<CartItem> getByCart(Cart cart) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<CartItem> query = session.createQuery(
                "FROM CartItem ci JOIN FETCH ci.product LEFT JOIN FETCH ci.product.productImage WHERE ci.cart.id = :cartId", CartItem.class);
            query.setParameter("cartId", cart.getId());
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public CartItem getByCartAndProduct(Cart cart, Product product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<CartItem> query = session.createQuery(
                "FROM CartItem ci WHERE ci.cart.id = :cartId AND ci.product.id = :productId", CartItem.class);
            query.setParameter("cartId", cart.getId());
            query.setParameter("productId", product.getId());
            return query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean save(CartItem cartItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.persist(cartItem);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(CartItem cartItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(cartItem);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(CartItem cartItem) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(cartItem);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
            return false;
        }
    }

    public void deleteAllByCart(Cart cart) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query<?> query = session.createQuery("DELETE FROM CartItem ci WHERE ci.cart = :cart");
            query.setParameter("cart", cart);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
