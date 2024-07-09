package com.inn.cafe2.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@Table(name = "FutGoals")
public class FutureGoals {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long Id;

    @Column(name = "description")
    public String Description;

    @Column(name = "amountQuantity")
    public Integer AmountQuantity;

    @Column(name = "currentAmount")
    public Integer CurrentAmount;

    //public Integer Type;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    public User user_id;

}
