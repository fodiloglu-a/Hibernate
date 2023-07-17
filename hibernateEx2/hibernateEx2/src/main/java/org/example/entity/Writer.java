package org.example.entity;
import jakarta.persistence.*;

import java.util.ArrayList;

import java.util.List;



@Entity
@Table(name = "WRITER")
public class Writer {
    @Id
    @SequenceGenerator(name = "writerSeq",sequenceName = "WRITER_SEQ_ID",allocationSize = 1)
    @GeneratedValue(generator = "writerSeq",strategy = GenerationType.SEQUENCE)
    @Column(name = "WRITER_ID")
    private Long id;
    @Column(name = "WRITER_NAME",length = 100)
    private String name;
    @ManyToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "writers"

    )
    private List<Book> books=new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    }

