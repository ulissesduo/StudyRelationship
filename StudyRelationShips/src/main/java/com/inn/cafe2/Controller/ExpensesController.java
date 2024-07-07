package com.inn.cafe2.Controller;

import com.inn.cafe2.DTO.Request.ExpensesRequest;
import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Service.IExpensesService;
import com.inn.cafe2.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {
    @Autowired
    private IUserService userService;
    @Autowired
    private IExpensesService expensesService;

    @GetMapping
    public List<Expenses> getAllExpenses(){
        return expensesService.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expenses getSpecificExpense(@PathVariable Long id) throws Exception{
            return expensesService.getExpenseById(id);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createExpense(@RequestBody ExpensesRequest request) {
        try {
            Long userId = request.getUserId();
            User user = userService.getUserById(userId);
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

    @PutMapping("/update/{id}")
    public ResponseEntity<Expenses> updateExpenses(@PathVariable Long id, @RequestBody ExpensesRequest expReq) throws Exception {
        Long userId = expReq.getUserId();
        expensesService.updateExpense(userId,id,expReq);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable Long id) throws Exception {
        expensesService.deleteExpenseById(id);
        return ResponseEntity.ok().build();
    }
}
