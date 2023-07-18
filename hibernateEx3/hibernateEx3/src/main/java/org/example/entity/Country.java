package org.example.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "COUNTRY")
public class Country {
    @SequenceGenerator(name = "seq", sequenceName = "COUNTRY_SEQ_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @Id
    @Column(name = "COUNTRY_ID")
    private Long id;
    @Column(name = "COUNTRY_NAME")
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
                mappedBy = "country",
            targetEntity = City.class
    )

    private Set citys=new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
