package org.example.main;

import org.example.dao.ProductDao;
import org.example.entity.Category;
import org.example.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductMain {
    public static void main(String[] args) {
        ProductDao productDao=new ProductDao();

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
        //
        productDao.save(product);
        productDao.update(product.getProduct_id(),product);
        productDao.getById(1);
        productDao.findAll();
        productDao.delete(product.getProduct_id());
    }
}
