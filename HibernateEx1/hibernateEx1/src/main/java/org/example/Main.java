package org.example;

import org.example.entity.ArmchairModel;
import org.example.entity.TicketModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.lang.reflect.AnnotatedType;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ArmchairModel armchairModel=new ArmchairModel();
        armchairModel.setNumber(1);
        TicketModel ticketModel=new TicketModel();
        ticketModel.setArmchairModel(armchairModel);
        ticketModel.setDate(new Date());
        ticketModel.setTime(new Date());
        ticketModel.setTicketCode("ACD-ER234");
        armchairModel.setTicketModel(ticketModel);

        SessionFactory sessionFactory=new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(ArmchairModel.class)
                .addAnnotatedClass(TicketModel.class)
                .buildSessionFactory();
        Session session=sessionFactory.openSession();
        Transaction transaction=session.getTransaction();
        transaction.begin();
        session.merge(armchairModel);
        session.merge(ticketModel);
        transaction.commit();
    }
}