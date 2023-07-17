package org.example1;

import hibernate.HibernateUtil;
import org.example1.entity.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        UserModel userModel=new UserModel();

        SessionFactory sessionFactory = HibernateUtil.sessionFactory.;

        Session session=sessionFactory.openSession();
        session.getTransaction().begin();
        session.merge(userModel);


    }
}