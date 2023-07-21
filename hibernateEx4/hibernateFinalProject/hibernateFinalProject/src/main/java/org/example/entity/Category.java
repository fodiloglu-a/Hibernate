package org.example.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

/*
*
* INSERT INTO `CATEGORY`(`CATEGORY_ID`, `CATEGORY_NAME`) VALUES
(1, 'BABY'),
(2, 'DRINK'),
(3, 'ELECTRONIC'),
(4, 'CLOTHING');
*/
@Entity
@Table(name = "CATEGORY")
public class Category {
    @Id
    @SequenceGenerator(
            name = "category_seq",
            sequenceName = "category_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "category_seq"
    )
    @Column(name = "CATEGORY_ID")
    private int category_id;
    @Column(name = "CATEGORY_NAME")
    private String category_name;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Product.class,
            mappedBy = "category"
    )
    private List<Product>products=new ArrayList<>();;


    @Override
    public String toString() {
        return "Category{" +
                "category_name='" + category_name + '\'' +

                '}';
    }

    public int getCategory_id() {
        return category_id;
    }



    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
