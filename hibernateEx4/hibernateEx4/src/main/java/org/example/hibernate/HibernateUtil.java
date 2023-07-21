package org.example.hibernate;




import org.example.entity.Category;
import org.example.entity.Vehicle;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            SessionFactory sessionFactory=new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Vehicle.class)
                    .buildSessionFactory();
            return sessionFactory;

        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
