package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.RecurringExpenses;

import java.util.List;

public interface IRecurringExpensesService {
    RecurringExpenses CreateNewRecurringExpense(RecurringExpenses reqExp);
    RecurringExpenses getRecExpById(Long id);
    List<RecurringExpenses> getAllRecExp();
    void deleteReqExp(Long id) throws Exception;

    RecurringExpenses updateRecExp(Long id, RecurringExpenses recExp) throws Exception;

}
