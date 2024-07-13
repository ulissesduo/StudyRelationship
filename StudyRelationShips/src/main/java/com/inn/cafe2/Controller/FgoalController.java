package com.inn.cafe2.Controller;

import com.inn.cafe2.DTO.Request.fgRequest;
import com.inn.cafe2.Entity.Fgoal;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Service.FgoalsService;
import com.inn.cafe2.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Fgoal")
public class FgoalController {

    @Autowired
    private IUserService userService;
    @Autowired
    private FgoalsService fgService;

    @GetMapping
    public List<Fgoal> getAllFutureGoals(){
        return fgService.getAllFG();
    }

    @GetMapping("/{id}")
    public Fgoal getSpecificFG(@PathVariable Long id){
        return fgService.getFGById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFG(@PathVariable Long id) throws Exception {
        fgService.deleteFGById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/add")
    public ResponseEntity<Void> createExpense(@RequestBody fgRequest request){
        try {
            Long userId = request.getUserId();
            User user = userService.getUserById(userId);
            Fgoal fg = new Fgoal();
            fg.setDescription(request.getDescription());
            fg.setAmountQuantity(request.getAmountQuantity());
            fg.setCurrentAmount(request.getCurrentAmount());
            fg.setUser(user);

            fgService.createExpenses(fg);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
