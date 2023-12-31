package org.example.hibernate;


import org.example.entity.Book;

import org.example.entity.Writer;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            SessionFactory sessionFactory=new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Book.class)
                    .addAnnotatedClass(Writer.class)
                    .buildSessionFactory();
            return sessionFactory;

        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
