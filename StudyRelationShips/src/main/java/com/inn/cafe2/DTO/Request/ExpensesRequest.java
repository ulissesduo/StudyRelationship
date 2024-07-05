package com.inn.cafe2.DTO.Request;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
@Getter
@Setter
public class ExpensesRequest {
    private Long userId; // User ID to associate the expense with
    private String description;
    private Double value;
    private Date paymentDate; // Optional: If payment date is not required at creation
    private Boolean statusPayment; // Optional: If payment status is not required at creation

    // Getters and setters
}
