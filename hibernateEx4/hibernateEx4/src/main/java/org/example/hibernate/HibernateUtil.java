package org.example.hibernate;




import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            SessionFactory sessionFactory=new Configuration()
                    .configure("hibernate.cfg.xml")

                    .buildSessionFactory();
            return sessionFactory;

        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
