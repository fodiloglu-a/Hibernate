package org.example.entity;

import jakarta.persistence.*;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "BOOK")
public class Book {
    @Id
    @SequenceGenerator(name = "bookSeq",sequenceName = "BOOK_SEQ_ID",allocationSize = 1)
    @GeneratedValue(generator = "bookSeq",strategy = GenerationType.SEQUENCE)
    @Column(name = "BOOK_ID")
    private Long id;
    @Column(name = "BOOK_NAME",length = 100)
    private String name;
    @ManyToMany(

            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )
    private List<Writer> writers=new ArrayList<>();

    public List<Writer> getWriters() {
        return writers;
    }

    public void setWriters(List<Writer> writers) {
        this.writers = writers;
    }

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
