package org.example.app;

import org.example.entity.Book;
import org.example.entity.Writer;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LibraryApp {
    public static void main(String[] args) {

        Book book=new Book();
        book.setName("KARAMAZOV KARDEŞLER");

        Writer writer=new Writer();

        writer.setName("Dostoyewsky");
        List<Writer> writers=new ArrayList<>();
        List<Book> books=new ArrayList<>();
        writers.add(writer);
        books.add(book);
        book.setWriters(writers);
        writer.setBooks(books);


        try {
            Session session= HibernateUtil.sessionFactory.openSession();
            Transaction transaction=session.getTransaction();
            transaction.begin();
            session.merge(writer);
            session.merge(book);
            transaction.commit();
        }catch (Exception e){
            throw new RuntimeException();
        }



    }
}
