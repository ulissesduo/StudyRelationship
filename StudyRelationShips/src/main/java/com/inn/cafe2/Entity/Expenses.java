package com.inn.cafe2.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="description")
    private String description;

    @Column(name="payment_date")
    private Date paymentDate;

    @Column(name="value")
    private Double value;

    @Column(name="status_payment")
    private Boolean statusPayment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
