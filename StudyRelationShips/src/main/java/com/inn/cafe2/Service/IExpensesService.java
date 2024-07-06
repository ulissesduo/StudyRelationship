package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.Expenses;

import java.util.List;

public interface IExpensesService {
    Expenses createExpenses(Expenses exp);
    Expenses getExpenseById(Long id);
    List<Expenses> getAllExpenses();
    void deleteExpenseById(Long id) throws Exception;
}
