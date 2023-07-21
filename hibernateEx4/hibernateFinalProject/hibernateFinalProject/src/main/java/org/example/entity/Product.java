package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_seq",sequenceName = "product_id_seq",allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_seq")
    @Column(name = "PRODUCT_ID")
    private int product_id;
    @Column(name = "PRODUCT_NAME")
    private String product_name;
    @ManyToOne(
            cascade =CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Category category;
    @Column(name = "PRODUCT_PRICE")
    private double price;

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_name='" + product_name + '\'' +

                ", price=" + price +
                '}';
    }

    public int getProduct_id() {
        return product_id;
    }



    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
