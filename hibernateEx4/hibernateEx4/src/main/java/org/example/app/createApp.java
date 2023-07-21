package org.example.app;

import org.example.entity.Category;
import org.example.entity.Vehicle;
import org.example.enums.CategoryType;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;


public class createApp {
    public static void main(String[] args) {
        //Vehicle
        Vehicle vehicle=new Vehicle();
        Vehicle vehicle1=new Vehicle();
        Vehicle vehicle2=new Vehicle();
        Vehicle vehicle3=new Vehicle();
        //name
        vehicle.setName("Vehicle One");
        vehicle2.setName("Vehicle Two");
        vehicle3.setName("Vehicle Three");
        vehicle1.setName("Vehicle Four");


        //category
        Category category=new Category();
        Category category1=new Category();
        Category category2=new Category();
        Category category3=new Category();
        //type
        category.setCategoryType(CategoryType.CAR);
        category1.setCategoryType(CategoryType.SHEP);
        category2.setCategoryType(CategoryType.BUS);
        category3.setCategoryType(CategoryType.TRIAN);
        //name
        category.setName("BUS");
        category1.setName("BUS");
        category2.setName("BUS");
        category3.setName("BUS");

        //vaicle
        List<Vehicle> vehicles=new ArrayList<>();
        List<Vehicle> vehicles1=new ArrayList<>();
        List<Vehicle> vehicles2=new ArrayList<>();
        List<Vehicle> vehicles3=new ArrayList<>();
        vehicles.add(vehicle);
        vehicles1.add(vehicle1);
        vehicles2.add(vehicle2);
        vehicles3.add(vehicle3);
        category.setVehicles(vehicles);
        category.setVehicles(vehicles1);
        category.setVehicles(vehicles2);
        category.setVehicles(vehicles3);

        //category
        vehicle.setCategory(category);
        vehicle2.setCategory(category2);
        vehicle3.setCategory(category3);
        vehicle1.setCategory(category1);
        //NUMBER
        vehicle.setNumber(1);
        vehicle1.setNumber(2);
        vehicle2.setNumber(3);
        vehicle3.setNumber(4);

        try {
            SessionFactory sessionFactory=new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Category.class)
                            .addAnnotatedClass(Vehicle.class)
                                    .buildSessionFactory();
            Session session=sessionFactory.openSession();
                        session.getTransaction().begin();
            session.merge(category);
            session.merge(category1);
            session.merge(category2);
            session.merge(category3);
            session.merge(vehicle);
            session.merge(vehicle2);
            session.merge(vehicle3);
            session.merge(vehicle1);
            session.getTransaction().commit();


        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }




}
