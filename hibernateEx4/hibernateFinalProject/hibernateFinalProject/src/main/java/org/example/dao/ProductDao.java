package org.example.dao;

import com.sun.jdi.PathSearchingVirtualMachine;
import org.example.entity.Product;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;

import org.hibernate.query.Query;

import java.util.List;


public class ProductDao {

    private static Session session(){
        Session session= HibernateUtil.sessionFactory.openSession();
        return session;
    }



    /***
     * CRUD OPREATINS FIND HEAR
     */


    public List<Product> findAll(){
        try {
            Query<Product> query = session().createQuery("select p from Product  p ", Product.class);
            return query.list();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }
    public Product getById(int id){
        try {
            Query<Product> query = session().createQuery("select p from Product  p where p.id=:id", Product.class);
            query.setParameter("id",id);

            return  query.uniqueResult();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public Product save (Product product){
        try {
            session().getTransaction().begin();
            session().merge(product);
            return product;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public String delete(int id){
        try {
            Query<Product> query = session().createQuery("select p from Product p where p.id=:id", Product.class);
            query.setParameter("id",id);
            session().detach(query.uniqueResult());
            return "DELETE";
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public Product update(int id,Product updateModel){
        try {
            Query<Product> query = session().createQuery("select p from Product p where p.id=:id", Product.class);
            query.setParameter("id",id);
            Product product=query.uniqueResult();
            product.setProduct_name(updateModel.getProduct_name());
            product.setCategory(updateModel.getCategory());
            product.setPrice(updateModel.getPrice());
            session().merge(product);

            return product;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }

    public static void main(String[] args) {
        ProductDao productDao=new ProductDao();
        ProductDao.session().getTransaction().begin();
        Query<Product> query = ProductDao.session().createQuery("select p from Product  p ", Product.class);
        List<Product> resultList = query.getResultList();
        resultList.stream().forEach(product -> product.getProduct_name());
    }

}
