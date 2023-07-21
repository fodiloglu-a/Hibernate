package org.example.hibernate;



import org.example.entity.Category;
import org.example.entity.Product;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            SessionFactory sessionFactory=new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Category.class)
                    .addAnnotatedClass(Product.class)
                    .buildSessionFactory();
            return sessionFactory;

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
}
