package com.inn.cafe2.Controller;

import com.inn.cafe2.DTO.Request.UserRequest;
import com.inn.cafe2.DTO.Request.UserWithExpensesRequest;
import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Service.IExpensesService;
import com.inn.cafe2.Service.IRecurringExpensesService;
import com.inn.cafe2.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IExpensesService expensesService;

    @Autowired
    private IRecurringExpensesService recurringExpensesService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws Exception {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }

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

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserRequest request) throws Exception {
        User user = userService.getUserById(id);
        if (user == null){
            return ResponseEntity.badRequest().build();
        }
        userService.updateUser(id,request);
        return ResponseEntity.ok(user);
    }
}
