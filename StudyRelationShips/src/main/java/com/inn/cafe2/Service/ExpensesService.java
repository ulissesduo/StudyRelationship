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
    public void deleteExpense(Long id) throws Exception {
        try{
            Expenses myExp = getExpenseById(id);

            if(myExp != null){
                repository.deleteById(id);
            }
        }
        catch(Exception e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public Expenses getExpenseById(Long id) {
        return repository.findById(id).orElse(null);
    }


}
