package org.example.entity;

import jakarta.persistence.*;

import java.util.Date;
@Entity
@Table(name = "TICKET_MODEL")
public class TicketModel {
    @SequenceGenerator(name = "ticket_seq",sequenceName = "TICKET_SEQ_ID",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "ticket_seq")
    @Id
    private Long id;
    @Column(name = "ticketCode" )
    private String ticketCode;
    @Column(name = "TICKET_TIME")
    @Temporal(TemporalType.TIME)
    private Date time;
    @Temporal(TemporalType.DATE)
    @Column(name = "TICKET_DATE")
    private Date date;
    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "ticketModel"
    )

    private ArmchairModel armchairModel;

    public ArmchairModel getArmchairModel() {
        return armchairModel;
    }

    public void setArmchairModel(ArmchairModel armchairModel) {
        this.armchairModel = armchairModel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
