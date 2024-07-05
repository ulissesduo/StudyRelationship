package com.inn.cafe2.Controller;

import com.inn.cafe2.DTO.Request.ExpensesRequest;
import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Service.IExpensesService;
import com.inn.cafe2.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IExpensesService expensesService;

    @PostMapping("/add")
    public ResponseEntity<Void> createExpense(@RequestBody ExpensesRequest request) {
        try {
            Long userId = request.getUserId();
            User user = userService.getById(userId);
            Expenses expense = new Expenses();
            expense.setDescription(request.getDescription());
            expense.setValue(request.getValue());
            if (request.getPaymentDate() != null) {
                expense.setPaymentDate(request.getPaymentDate());
            }
            if (request.getStatusPayment() != null) {
                expense.setStatusPayment(request.getStatusPayment());
            }
            expense.setUser(user);
            expensesService.createExpenses(expense);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpenses(@RequestParam Long id) throws Exception {
        expensesService.deleteExpense(id);
    }

}
