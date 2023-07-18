package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "City",
        indexes = {
                @Index(name = "City_ID_NAME" ,columnList = "City_ID,City_NAME"),
                @Index(name = "CITI_NAME_COUNTRY",columnList = "City_NAME,COUNTRY_ID")
        }



)
public class City {
    @SequenceGenerator(name = "seq", sequenceName = "City_SEQ_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @Id
    @Column(name = "City_ID")
    private Long id;
    @Column(name = "City_NAME")
    private String name;
    @ManyToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    @JoinColumn(
            name = "COUNTRY_ID",
            nullable = false,
            foreignKey = @ForeignKey(
                    name = "COUNTRY_FOREIGN_KEY",
                    value = ConstraintMode.CONSTRAINT,
                    foreignKeyDefinition = "foreign key (COUNTRY_ID) references COUNTRY (COUNTRY_ID)"

            )
    )
    private Country country;

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

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}