package org.example.entity;

import jakarta.persistence.*;


@Entity
@Table(
        name = "VEHICLE_MODEL"
)
public class Vehicle {
    @SequenceGenerator(name = "seqq",sequenceName = "VEHICLE_ID_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seqq")
    @Id
    @Column(name = "ID",length = 11)
    private Long id;
    @Column(name = "VEHICLE_NAME" )
    private String vehicleName;

    @Column(name = "VEHİCLE_NO")
    private int number;

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @ManyToOne(
            cascade =CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return vehicleName;
    }

    public void setName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}