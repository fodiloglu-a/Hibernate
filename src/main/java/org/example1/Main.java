package org.example1;

import org.example1.entity.UserModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
        UserModel userModel=new UserModel();
        userModel.setUserName("Test User");

        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserModel.class)
                .buildSessionFactory();

         Session session=sessionFactory.openSession();
        try {

            Transaction transaction= session.getTransaction();
            transaction.begin();
            session.merge(userModel);
            transaction.commit();

        }catch (Exception e){
            System.out.println("Confugration Exception"+e);
        }finally {
            session.close();
        }


    }
}