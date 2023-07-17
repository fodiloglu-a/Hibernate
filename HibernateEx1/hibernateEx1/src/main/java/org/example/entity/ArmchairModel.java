package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ARMCHAIR_MODEL")
public class ArmchairModel {
    @Id
    @SequenceGenerator(name = "seq",sequenceName = "ARMCHAIR_ID_SEQ",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    @Column(name = "ID",nullable = false,updatable = false,length = 10)
    private Long id;
    @Column(name = "ARMCHAIR_NUMBER",nullable = false,length = 3)
    private int number;

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY

    )

    private TicketModel ticketModel;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public TicketModel getTicketModel() {
        return ticketModel;
    }

    public void setTicketModel(TicketModel ticketModel) {
        this.ticketModel = ticketModel;
    }
}
