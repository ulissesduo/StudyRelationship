package com.inn.cafe2.DTO.Request;

import com.inn.cafe2.Entity.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FutGoalsRequest {

//    public Long Id;


    public String Description;

    public Integer AmountQuantity;

    public Integer CurrentAmount;

    //public Integer Type;

    public Long userid;
}
