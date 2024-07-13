package com.inn.cafe2.Entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="fg")
public class Fgoal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "description")
    private String Description;

    @Column(name="amountQuantity")
    private Double amountQuantity;

    @Column(name = "currentAmount")
    private Double currentAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
