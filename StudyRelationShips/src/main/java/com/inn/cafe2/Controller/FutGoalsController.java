package com.inn.cafe2.Controller;

import com.inn.cafe2.DTO.Request.FutGoalsRequest;
import com.inn.cafe2.Entity.FutureGoals;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Repository.IFutGoalsRepository;
import com.inn.cafe2.Service.IFutGoalsService;
import com.inn.cafe2.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("futgoals")
public class FutGoalsController {
    @Autowired
    private IFutGoalsService futgoalService;

    @Autowired
    private IUserService userService;

    @PostMapping("/add")
    public ResponseEntity<FutureGoals> createFutGoal(@RequestBody FutGoalsRequest futgoals){
        Long userId = futgoals.getUserid();
        User user = userService.getUserById(userId);
        FutureGoals fg = new FutureGoals();
        fg.setDescription(futgoals.getDescription());
        fg.setAmountQuantity(futgoals.getAmountQuantity());
        fg.setCurrentAmount(futgoals.getCurrentAmount());
        FutureGoals futgoal =  futgoalService.createFutGoals(fg);
        futgoal.setUser_id(user);
        return ResponseEntity.ok().build();
    }
}
