package com.rmro.viva.util;

import com.rmro.viva.dao.ProductDAO;
import com.rmro.viva.entity.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DataSeeder {

    private static final String A = "https://lh3.googleusercontent.com/aida-public/AB6AXuC6ZZj6ESf5mufIcQqVywI3sN4ePCAFxi0h9c6Cz6FJjrUbOfz1KRIa1Cp0R8-pgFLsTISJMBMffMx7wp1LKjLmZ6uSgRBYfgdMOaY6sQ3V5P7gXycD7rGFz0ks6cHWLYMp6cRsseImbvBCkqBTSbmpnbgj7pbR4VsljO0FkPcnJemHmZ3j0SIEs76QuaULMANwBP3pcL1qNovCdCCNGoH105KePH2ZPs6idMto9SbUOcMgud5cifyoaJiDYc6MhwHpHkReyAItWCix";
    private static final String B = "https://lh3.googleusercontent.com/aida-public/AB6AXuCk1pPozeiT1Ml-mVNWZ4I8Bz2aJPhZspg-JgqvAw4T-qfe7zLHJC-6ejmtssjzKMTQHFks7BeiKgH0wJI2Mad4rikEh8NNTqb-xyfkX-MA9h-fY7C8AOXi6osO25gf0ACo9rx40h9mpW-f9N7z5yM0wBbxyO6qjd2zRgcxPxGOCsKihm0WfPYKByOuYdVCdWQnwpZBLLQhCnmYx4yVgeKZ-tmI6Irn_XV9-31HtGeyR8Ua6-o9pK678B2disMOYO0R6Seaw-arULy7";
    private static final String C = "https://lh3.googleusercontent.com/aida-public/AB6AXuBPzdJiHXWMv-9AbYBVK-WWRrsql5bBob4BlBmDRzOqJmXu03o1ZPl667pliQ2gGHYZjwdRjfuQZQ2Fl06GMzmbq9wUBZH9nN7wdU2q9_8u1gxd-yaPY6vLxvpL4xopBnUp3HCQ76j2949HNDIN8s9is6CExQVC13zEtKqmUFE419NURC7aeKHPomxUBBQJkPykZD1pzqIu_anFkGRmNAR4ZF2zJ7rQD_gT6lpGUzj1eqjYiPBU0TALQHoXcRX7pVLQfblLKEfkya79";
    private static final String D = "https://lh3.googleusercontent.com/aida-public/AB6AXuDp32tt144VETdPtn5p2F8mn-xpTd2BX5svBh_VMZ9FCaYAZlkjsphkJGmLG1CO3NpyTzG-T-8e8mOWnEOiMIAq_otUi2v9BvbNzIE3J5Krw1LGLX5FLB6jYeepkVQilt3lR0c16z6fQrza0kdvEtKZ0VEixY9ddM3whuHFBwq5MT3HVlWxnJO23mM54PHlIbgh9ZT6IMSd4r4u7TpjJnTozVjxZBchY-YaiNCfDjtW_RIs4lEvIywH4qN_F-Hn13Zbsf0hXAZ1ggSQ";
    private static final String E = "https://lh3.googleusercontent.com/aida-public/AB6AXuCI7bfxDPMhWT0MgugepCj-3LU-kthvh-L_DSLN1nSCnTXt1TG7LFAO-2_8c_GrpYC5a7ElyQYm2Ly2vW3C4VHQqqvkL4OrrrjXVHS2WJJwpOgm9_c1H16g8JA9zYEG5agoqfpNvLlru4KmqoDdrua0VU2bW-XoELUFMNnIZ4sVSp9Q9yfzEQ1g-az73_5VNWtykddfaklIXauxczLFBvqTSbaqhoeNd4i2zvn94j8pndO49lpBTwwtx-BP2znaVWG2cqPemfwwQuAm";
    private static final String F = "https://lh3.googleusercontent.com/aida-public/AB6AXuCbEIwRil3IroEEnFACd_iGjtvyIoqweMOouPDEUqHe2poccINvsIhDvjKGxZpVf3Ylv8xgZtiY7mg5RORCoPgF3769DWr9Gr86sh4HBu__Ejjht4rDexVTTWyuFu2eGoFoNy4yir_iYRmexeqF9wmWO6jbqM07sLNVoq-ceUJ63TkGtOpxvpr06niQlK30QMJVFiay9z7qSlJlZP3nJFibZzVUuB6wJa62nLzHvH-k-cSQgWkj4Kb5FxkZSeRnNMfYZvoblJv2upaz";
    private static final String G = "https://lh3.googleusercontent.com/aida-public/AB6AXuBrsPquvsy2evDe2T3ahHdzIIDdLP9B_CltfM48HepF9YLvpmQZOASu_No1rhbI4LIpdeGYugMFX0hsDZ4xPa3u8H_0xPRXuRcepbHXNw2QDOipEm-epdjnm2QaUH-VT80lcxRpqGApb9dWF6W4zRwWVq23iCwzbypyXEcaObq7oDO0taPhSzD9Z3IcthkCXlNtrTiRvC1716OUNI-s7TFs6r1b2oeWSguKNbihlJEmLsgf6-gqNxWRMZ8dAXHFgxrlna7Pdn1-ure2";

    public void seed() {
        ProductDAO productDAO = new ProductDAO();
        if (productDAO.countAll() > 0) {
            try (Session session = HibernateUtil.getSessionFactory().openSession()) {
                Transaction tx = session.beginTransaction();
                session.createQuery("DELETE FROM CartItem").executeUpdate();
                session.createQuery("DELETE FROM Wishlist").executeUpdate();
                session.createQuery("DELETE FROM Review").executeUpdate();
                session.createQuery("DELETE FROM OrderItem").executeUpdate();
                session.createQuery("DELETE FROM Stock").executeUpdate();
                session.createQuery("DELETE FROM Product").executeUpdate();
                session.createQuery("DELETE FROM ProductImage").executeUpdate();
                session.createQuery("DELETE FROM ProductAttribute").executeUpdate();
                session.createQuery("DELETE FROM Brand").executeUpdate();
                session.createQuery("DELETE FROM Category").executeUpdate();
                tx.commit();
            }
        }

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Transaction tx = session.beginTransaction();

            Status activeStatus = getOrCreateStatus(session, "active");
            County intlCounty = getOrCreateCounty(session, "International");

            getOrCreateOrderStatus(session, "PENDING");
            getOrCreateOrderStatus(session, "PROCESSING");
            getOrCreateOrderStatus(session, "SHIPPED");
            getOrCreateOrderStatus(session, "DELIVERED");
            getOrCreateOrderStatus(session, "CANCELLED");

            getOrCreatePaymentMethod(session, "CREDIT_CARD");
            getOrCreatePaymentMethod(session, "COD");

            getOrCreatePaymentStatus(session, "UNPAID");
            getOrCreatePaymentStatus(session, "PAID");
            getOrCreatePaymentStatus(session, "REFUNDED");

            getOrCreateRole(session, "Customer");
            getOrCreateRole(session, "Admin");

            createUser(session, "admin@viva.com", "Admin", "User", "0000000000", "Admin123!", "Admin", activeStatus);
            createUser(session, "test@example.com", "Test", "User", "1234567890", "Test1234!", "Customer", activeStatus);

            Category whisky = createCategory(session, "Whisky", "Whisky is a distilled alcoholic beverage made from fermented grain mash.", activeStatus);
            Category wine = createCategory(session, "Wine", "Wine is an alcoholic drink made from fermented grapes.", activeStatus);
            Category vodka = createCategory(session, "Vodka", "Vodka is a clear distilled alcoholic beverage from fermented substances.", activeStatus);
            Category rum = createCategory(session, "Rum", "Rum is a distilled alcoholic drink made from sugarcane byproducts.", activeStatus);
            Category gin = createCategory(session, "Gin", "Gin is a distilled alcoholic drink flavoured with juniper berries.", activeStatus);
            Category beer = createCategory(session, "Beer", "Beer is one of the oldest alcoholic drinks, brewed from cereal grains.", activeStatus);
            Category champagne = createCategory(session, "Champagne", "Champagne is a sparkling wine produced in the Champagne region of France.", activeStatus);
            Category tequila = createCategory(session, "Tequila", "Tequila is a distilled beverage made from the blue agave plant.", activeStatus);
            Category liqueur = createCategory(session, "Liqueur", "Liqueur is a sweet alcoholic drink flavoured with fruit, herbs, or spices.", activeStatus);
            Category brandy = createCategory(session, "Brandy", "Brandy is a spirit produced by distilling wine.", activeStatus);

            Brand highland = createBrand(session, "Highland Distillery", "Premium Scotch whisky distiller", intlCounty, activeStatus);
            Brand botanical = createBrand(session, "Botanical Spirits Co.", "Artisanal gin crafters", intlCounty, activeStatus);
            Brand heritage = createBrand(session, "Heritage Rum Co.", "Aged rum specialists", intlCounty, activeStatus);
            Brand vintage = createBrand(session, "Vintage Cellars", "Luxury champagne house", intlCounty, activeStatus);
            Brand speyside = createBrand(session, "Speyside Distillery", "Rare malt whisky distiller", intlCounty, activeStatus);
            Brand chateau = createBrand(session, "Ch\u00e2teau Margaux", "Premier Grand Cru Bordeaux", intlCounty, activeStatus);
            Brand crystal = createBrand(session, "Crystal Clear", "Ultra premium vodka", intlCounty, activeStatus);

            ProductAttribute volAttr = new ProductAttribute("Volume", "750ml");
            session.persist(volAttr);

            ProductImage img1 = new ProductImage(A); session.persist(img1);
            ProductImage img2 = new ProductImage(B); session.persist(img2);
            ProductImage img3 = new ProductImage(C); session.persist(img3);
            ProductImage img4 = new ProductImage(D); session.persist(img4);
            ProductImage img5 = new ProductImage(E); session.persist(img5);
            ProductImage img6 = new ProductImage(F); session.persist(img6);
            ProductImage img7 = new ProductImage(G); session.persist(img7);

            createProduct(session, 1, "The Golden Cask 18yr", "A masterful Highland single malt scotch whiskey aged 18 years in oak casks, with notes of honey, vanilla, and dried fruit.", new BigDecimal("46.00"), "GOLD-18", highland, whisky, img1, volAttr, new BigDecimal("189"), 50);
            createProduct(session, 2, "Botanical No. 7 Reserve", "An artisanal small-batch gin infused with 7 hand-selected botanicals including juniper, coriander, and angelica root.", new BigDecimal("43.00"), "BOT-7", botanical, gin, img2, volAttr, new BigDecimal("65"), 80);
            createProduct(session, 3, "Heritage Spiced 25yr", "A magnificent 25-year aged rum with rich molasses and spice character, finished in sherry casks.", new BigDecimal("42.00"), "HER-SP25", heritage, rum, img3, volAttr, new BigDecimal("120"), 35);
            createProduct(session, 4, "Vintage Blanc de Noirs", "A prestigious champagne made exclusively from black grapes, aged 8 years on the lees for exceptional complexity.", new BigDecimal("12.50"), "VIN-BN", vintage, champagne, img4, volAttr, new BigDecimal("340"), 20);
            createProduct(session, 5, "Speyside Rare Malt 1994", "A rare single malt Scotch whisky distilled in 1994, with profound notes of dark chocolate, sherry, and aged oak.", new BigDecimal("47.00"), "SPEY-94", speyside, whisky, img5, volAttr, new BigDecimal("525"), 15);
            createProduct(session, 6, "Ch\u00e2teau Margaux 2018", "A legendary Premier Grand Cru Class\u00e9 from Bordeaux, offering elegant tannins and a remarkably long finish.", new BigDecimal("13.50"), "CM-2018", chateau, wine, img6, volAttr, new BigDecimal("890"), 10);
            createProduct(session, 7, "Crystal Clear Ultra Premium", "Handcrafted Polish vodka distilled four times from premium rye grain, then filtered through diamond dust.", new BigDecimal("40.00"), "CC-Ultra", crystal, vodka, img7, volAttr, new BigDecimal("45"), 120);

            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Status getOrCreateStatus(Session session, String name) {
        org.hibernate.query.Query<Status> q = session.createQuery("FROM Status WHERE name = :name", Status.class);
        q.setParameter("name", name);
        Status s = q.uniqueResult();
        if (s == null) {
            s = new Status(name);
            session.persist(s);
        }
        return s;
    }

    private County getOrCreateCounty(Session session, String name) {
        org.hibernate.query.Query<County> q = session.createQuery("FROM County WHERE name = :name", County.class);
        q.setParameter("name", name);
        County c = q.uniqueResult();
        if (c == null) {
            c = new County(name);
            session.persist(c);
        }
        return c;
    }

    private Category createCategory(Session session, String name, String description, Status status) {
        Category c = new Category(name, description, LocalDate.now(), status);
        session.persist(c);
        return c;
    }

    private Brand createBrand(Session session, String name, String desc, County county, Status status) {
        Brand b = new Brand(name, desc, null, county, status);
        session.persist(b);
        return b;
    }

    private void createProduct(Session session, int id, String name, String desc, BigDecimal alcPct,
                                String sku, Brand brand, Category category, ProductImage image,
                                ProductAttribute attr, BigDecimal price, int stockQty) {
        Product p = new Product(id, name, desc, alcPct, sku, brand, category);
        p.setProductImage(image);
        p.setProductAttribute(attr);
        session.persist(p);

        Stock s = new Stock(stockQty, 0, stockQty, "Initial stock", price, BigDecimal.ZERO, LocalDate.now(), p);
        session.persist(s);
    }

    private Role getOrCreateRole(Session session, String name) {
        org.hibernate.query.Query<Role> q = session.createQuery("FROM Role WHERE name = :name", Role.class);
        q.setParameter("name", name);
        Role r = q.uniqueResult();
        if (r == null) {
            r = new Role(name);
            session.persist(r);
        }
        return r;
    }

    private void createUser(Session session, String email, String fName, String lName,
                            String mobile, String plainPassword, String roleName, Status status) {
        org.hibernate.query.Query<User> q = session.createQuery("FROM User WHERE email = :email", User.class);
        q.setParameter("email", email);
        User existing = q.uniqueResult();
        if (existing != null) {
            Role role = getOrCreateRole(session, roleName);
            existing.setfName(fName);
            existing.setlName(lName);
            existing.setMobile(mobile);
            existing.setPasswordHash(com.rmro.viva.util.PasswordUtil.hashPassword(plainPassword));
            existing.setRole(role);
            existing.setStatus(status);
            session.merge(existing);
            return;
        }
        Role role = getOrCreateRole(session, roleName);
        String hash = com.rmro.viva.util.PasswordUtil.hashPassword(plainPassword);
        User user = new User(fName, lName, email, mobile, hash, role, status);
        session.persist(user);
    }

    private OrderStatus getOrCreateOrderStatus(Session session, String name) {
        org.hibernate.query.Query<OrderStatus> q = session.createQuery("FROM OrderStatus WHERE name = :name", OrderStatus.class);
        q.setParameter("name", name);
        OrderStatus os = q.uniqueResult();
        if (os == null) {
            os = new OrderStatus();
            os.setName(name);
            session.persist(os);
        }
        return os;
    }

    private PaymentMethod getOrCreatePaymentMethod(Session session, String name) {
        org.hibernate.query.Query<PaymentMethod> q = session.createQuery("FROM PaymentMethod WHERE name = :name", PaymentMethod.class);
        q.setParameter("name", name);
        PaymentMethod pm = q.uniqueResult();
        if (pm == null) {
            pm = new PaymentMethod();
            pm.setName(name);
            session.persist(pm);
        }
        return pm;
    }

    private PaymentStatus getOrCreatePaymentStatus(Session session, String name) {
        org.hibernate.query.Query<PaymentStatus> q = session.createQuery("FROM PaymentStatus WHERE name = :name", PaymentStatus.class);
        q.setParameter("name", name);
        PaymentStatus ps = q.uniqueResult();
        if (ps == null) {
            ps = new PaymentStatus();
            ps.setName(name);
            session.persist(ps);
        }
        return ps;
    }
}
