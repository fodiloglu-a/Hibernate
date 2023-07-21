package org.example.services;

import org.example.dao.ProductDao;
import org.example.entity.Product;
import org.hibernate.query.Query;

import java.util.List;

public class ProductServices {
   private static ProductDao productDao;

    public ProductServices() {
        productDao=new ProductDao();
    }

    private List<Product> findAll(){
        try {
            return productDao.findAll();
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }
    private Product getById(int id){
        try {

            return productDao.getById(id);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    private Product save (Product product){
        try {
            return productDao.save(product);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    private String delete(int id){
        try {
            return productDao.delete(id);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }

    }
    private Product update(int id,Product updateModel){
        try {
            return productDao.update(id,updateModel);

        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }


    }

}
