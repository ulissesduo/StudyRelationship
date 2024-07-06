package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Repository.IExpensesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesService implements IExpensesService{
    @Autowired
    private IExpensesRepository repository;

    @Override
    @Transactional
    public Expenses createExpenses(Expenses exp) {
        return repository.save(exp);
    }


    @Override
    public void deleteExpenseById(Long id) throws Exception {
        Expenses expense = repository.findById(id).orElse(null);
        if (expense == null) {
            throw new Exception("Expense not found with ID: " + id);
        }
        repository.delete(expense);
    }

    @Override
    public Expenses getExpenseById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Expenses> getAllExpenses() {
        return repository.findAll();
    }
}
