package org.example.services;

import org.example.dao.CategoryDao;
import org.example.entity.Category;

import java.util.List;

public class CategoryServices {
    public static void main(String[] args) {
        CategoryDao categoryDao=new CategoryDao();

        List<Category> categories=categoryDao.findAll();
        for (Category category : categories) {
            System.out.println(category.getName());
        }
    }
}
