package com.inn.cafe2.Controller;

import com.inn.cafe2.DTO.Request.UserWithExpensesRequest;
import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Service.IExpensesService;
import com.inn.cafe2.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IExpensesService expensesService;

    @PostMapping("/add")
    public ResponseEntity<User> createUserWithExpenses(@RequestBody UserWithExpensesRequest request) {
        User user = userService.createUser(request.getUser());
        List<Expenses> expenses = request.getExpenses();
        for (Expenses expense : expenses) {
            expense.setUser(user);
            expensesService.createExpenses(expense);
        }
        return ResponseEntity.ok(user);
    }
}
