package com.inn.cafe2.DTO.Request;

import com.inn.cafe2.Entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class RecExpRequest {

    private String Description;
    private Double Amount;
    private Date PaymentDate;
    private Integer Frequency;
    private Date initialDate;
    private Date FinalDate;
    private Long userId; // User ID to associate the expense with
}
