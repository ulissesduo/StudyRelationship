package com.inn.cafe2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@Entity
@DynamicInsert
@DynamicUpdate
@Table(name="recurring_expenses")
public class RecurringExpenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="Description")
    private String Description;

    @Column(name="Amount")
    private Double Amount;

    @Column(name="PaymentDate")
    private Date PaymentDate;

    @Column(name="Frequency")
    private Integer Frequency;

    @Column(name="InitialDate")
    private Date initialDate;

    @Column(name="FinalDate")
    private Date FinalDate;

    //    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
