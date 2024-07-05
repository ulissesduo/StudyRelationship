package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.RecurringExpenses;
import com.inn.cafe2.Repository.IRecurringExpenses;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecurringExpensesService implements IRecurringExpensesService {

    @Autowired
    private IRecurringExpenses repository;

    @Override
    @Transactional
    public RecurringExpenses CreateNewRecurringExpense(RecurringExpenses reqExp) {
        return repository.save(reqExp);
    }
}
