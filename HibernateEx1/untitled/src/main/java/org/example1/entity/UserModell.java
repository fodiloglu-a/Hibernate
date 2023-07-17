package org.example1.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_MODEdL")
public class UserModell {
    @Id
    private int id;

}
