package org.example.app;

import org.example.entity.ArmchairModel;
import org.example.entity.TicketModel;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;


public class TicketApp {



    public static void main(String[] args) {
        TicketModel ticketModel=new TicketModel();
        ticketModel.setTicketCode("CODE");
        ticketModel.setDate(new Date());
        ticketModel.setTime(new Date());
        ArmchairModel armchairModel=new ArmchairModel();
        armchairModel.setNumber(123);
        armchairModel.setTicketModel(ticketModel);
        ticketModel.setArmchairModel(armchairModel);

        Session session= HibernateUtil.sessionFactory.openSession();

        Transaction transaction= session.getTransaction();

        try {
            transaction.begin();
            session.merge(ticketModel);
            session.merge(armchairModel);
            transaction.commit();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }
}
