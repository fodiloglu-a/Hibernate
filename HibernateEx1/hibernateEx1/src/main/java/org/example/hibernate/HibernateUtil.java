package org.example.hibernate;

import org.example.entity.ArmchairModel;
import org.example.entity.TicketModel;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    public static final SessionFactory sessionFactory=buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            SessionFactory sessionFactory=new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(ArmchairModel.class)
                    .addAnnotatedClass(TicketModel.class)
                    .buildSessionFactory();
            return sessionFactory;

        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
