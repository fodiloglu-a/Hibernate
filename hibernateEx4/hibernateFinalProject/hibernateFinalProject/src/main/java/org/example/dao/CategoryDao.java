package org.example.dao;

import org.example.entity.Category;
import org.example.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDao {
    private static final Session session = HibernateUtil.sessionFactory.openSession();

    public CategoryDao(){
        session.getTransaction().begin();

    }
    /**
     * CRUD METHOD FOR CATEGORY FINDING HEAR
     */
    public List<Category> findAll(){
        try {
            Query<Category> query = session.createQuery("select c from Category c", Category.class);
            return query.list();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public Category getById(int id){
        try {
            Query<Category> query = session.createQuery("select c from Category c where c.id=:id", Category.class);
            query.setParameter("id",id);
            return query.uniqueResult();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }
    public Category save (Category category){
        try {
             session.merge(category);
             session.getTransaction().commit();

            return category;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public String delete(int id){
        try {
            Query<Category> query = session.createQuery("select c from  Category  c where c.id=:id", Category.class);
            query.setParameter("id",id);
            Category category=query.uniqueResult();
            session.detach(category);
            return "DELETE";
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public Category update(int id,Category updateModel){
       try {
           Query<Category> query = session.createQuery("select c from Category  c where c.id=:id", Category.class);
           query.setParameter("id",id);
           Category category=query.uniqueResult();
           category.setCategory_name(updateModel.getCategory_name());
           category.setProducts(updateModel.getProducts());
           session.merge(category);
           return category;
       }catch (Exception e){
           throw new RuntimeException(e.getMessage());
       }


    }


}
