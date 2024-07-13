package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.Fgoal;

import java.util.List;

public interface IFutGoalsService {
    Fgoal createExpenses(Fgoal fgoal);
    Fgoal getFGById(Long id);

    List<Fgoal> getAllFG();
    void deleteFGById(Long id) throws Exception;

}
