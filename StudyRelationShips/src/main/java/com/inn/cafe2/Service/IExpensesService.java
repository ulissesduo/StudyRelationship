package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.Expenses;

import java.util.List;

public interface IExpensesService {
    Expenses createExpenses(Expenses exp);

    void deleteExpense(Long id) throws Exception;

    Expenses getExpenseById(Long id);

}
