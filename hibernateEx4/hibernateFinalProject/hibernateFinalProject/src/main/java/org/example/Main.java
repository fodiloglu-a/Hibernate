package org.example;

import org.example.entity.Category;
import org.example.entity.Product;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.sessionFactory.openSession();
        session.getTransaction().begin();
        Product product=new Product();
        product.setProduct_name("dsfsdfsd");
        product.setCategory(new Category());
        product.setPrice(12.2);
        session.merge(product);
        session.getTransaction().commit();

    }
}