package org.example.app;

import org.example.entity.City;
import org.example.entity.Country;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;


public class MantToOneApp {
    public static void main(String[] args) {
        City city=new City();
        City city3=new City();
        City city1=new City();
        city1.setName("Amed");
        city3.setName("Amed");
        Country country=new Country();

        city.setName("Bingol");
        city3.setName("Bingol");
        country.setName("Turkey");
        city.setCountry(country);
        city1.setCountry(country);
        city3.setCountry(country);

            Session session= HibernateUtil.sessionFactory.openSession();
            session.getTransaction().begin();
            session.merge(city);
            session.merge(city1);
            session.merge(city3);
            session.getTransaction().commit();



    }
}
