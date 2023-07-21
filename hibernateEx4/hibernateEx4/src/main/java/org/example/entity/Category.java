package org.example.entity;

import jakarta.persistence.*;
import org.example.enums.CategoryType;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(
        name = "CATEGORY_MODEL"
)
public class Category {
    @SequenceGenerator(name = "category_seq",sequenceName = "CATEGORY_ID_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "category_seq")
    @Id
    @Column(name = "ID",length = 11)
    private Long id;
    //@Column(name = "CATEGORY_NAME" )
    private String categoryName;
    @Enumerated(EnumType.STRING)
    @Column(name = "CATEGORY_TYPE")
    private CategoryType categoryType;
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            targetEntity = Vehicle.class,
            mappedBy = "category"
    )
    private List<Vehicle> vehicles =new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return categoryName;
    }

    public void setName(String name) {
        this.categoryName = name;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(CategoryType categoryType) {
        this.categoryType = categoryType;
    }

    public List getVehicles() {
        return vehicles;
    }

    public void setVehicles(List vehicles) {
        this.vehicles = vehicles;
    }
}
