package com.inn.cafe2.DTO.Request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fgRequest {
    private Long userId; // User ID to associate the expense with
    private String Description;
    private Double amountQuantity;
    private Double currentAmount;
}
