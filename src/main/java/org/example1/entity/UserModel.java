package org.example1.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "user_model")
public class UserModel {
    @Id
    @SequenceGenerator(name = "seq",sequenceName = "user_model_id_seq",initialValue = 11,allocationSize = 2)
    /**
     * name_SequensGeneretor adıdır
     * sequesnceName=Sequnseadıdır
     * initialValue=değerin kaçta başlaması gerektiğini söyler
     * allocationSize=artış miktarını gösterir
     */
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
    private Long id;

    @Column(name =
    "user_name",length = 100,nullable = false,updatable = false)
    private String userName;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Column(name = "big_decimal",
    precision = 5,scale = 2)
    private BigDecimal bigDecimal;



    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Long getId() {
        return id;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
