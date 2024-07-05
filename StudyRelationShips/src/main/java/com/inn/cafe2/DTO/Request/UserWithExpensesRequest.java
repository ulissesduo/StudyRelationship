package com.inn.cafe2.DTO.Request;

import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UserWithExpensesRequest {
    private User user;
    private List<Expenses> expenses;

}
