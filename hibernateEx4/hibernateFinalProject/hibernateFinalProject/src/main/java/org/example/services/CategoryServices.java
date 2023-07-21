package org.example.services;

import org.example.dao.CategoryDao;
import org.example.entity.Category;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryServices {
    private static CategoryDao categoryDao;

    public CategoryServices(){
        categoryDao=new CategoryDao();
    }


    public List<Category> findAll(){
        try {
            List<Category>categories=categoryDao.findAll();
            return categories;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public Category getById(int id){
        try {
           Category category= categoryDao.getById(id);
           return category;
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }
    public Category save (Category category){
        try {

             return categoryDao.save(category);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public String delete(int id){
        try {
            return categoryDao.delete(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    public Category update(int id,Category updateModel){
        try {

            return categoryDao.update(id,updateModel);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }

}
