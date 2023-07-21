package org.example.main;

import org.example.entity.Category;
import org.example.entity.Product;
import org.example.services.CategoryServices;

import java.util.ArrayList;
import java.util.List;

public class CategoryMain {
    public static void main(String[] args) {
        CategoryServices categoryServices=new CategoryServices();

        //findAll
        for (Category category : categoryServices.findAll()) {
            System.out.println(category.toString());
        }
        //getById
        Category byId = categoryServices.getById(1);
        System.out.println(byId.toString());
        //
        Category category=new Category();
        category.setCategory_name("category");

        Product product=new Product();
        product.setCategory(category);
        product.setProduct_name("product");
        product.setPrice(12.12);
        List<Product> products = new ArrayList<>();
        products.add(product);
        category.setProducts(products);
        //update
        Category update = categoryServices.update(1, category);
        System.out.println(update.toString());

        //save
        Category save = categoryServices.save(category);
        System.out.println(save.toString());
        //delete
        String delete = categoryServices.delete(category.getCategory_id());
        System.out.println(delete);


    }
}
