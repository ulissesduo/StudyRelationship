package com.inn.cafe2.Controller;

import com.inn.cafe2.DTO.Request.RecExpRequest;
import com.inn.cafe2.Entity.RecurringExpenses;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Service.IRecurringExpensesService;
import com.inn.cafe2.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/recExp")
public class RecurringExpensesController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IRecurringExpensesService recurringExpensesService;

    @GetMapping
    public RecurringExpenses getAllRecExp(){
        return null;
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createRecExp(@RequestBody RecExpRequest request){
        try{
            Long userId = request.getUserId();
            User user = userService.getUserById(userId);

            RecurringExpenses reqexp = new RecurringExpenses();
            reqexp.setAmount(request.getAmount());
            reqexp.setDescription(request.getDescription());
            reqexp.setFrequency(request.getFrequency());
            reqexp.setFinalDate(request.getFinalDate());
            reqexp.setInitialDate(request.getInitialDate());
            reqexp.setUser(user);

            recurringExpensesService.CreateNewRecurringExpense(reqexp);

            return ResponseEntity.ok().build();
        }
        catch (Exception e){
            return ResponseEntity.badRequest().build();
        }

    }
}
