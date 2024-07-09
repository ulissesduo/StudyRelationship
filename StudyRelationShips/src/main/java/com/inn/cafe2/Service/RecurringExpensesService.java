package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.RecurringExpenses;
import com.inn.cafe2.Repository.IRecurringExpenses;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecurringExpensesService implements IRecurringExpensesService {

    @Autowired
    private IRecurringExpenses repository;

    @Override
    @Transactional
    public RecurringExpenses CreateNewRecurringExpense(RecurringExpenses reqExp) {
        return repository.save(reqExp);
    }

    @Override
    @Transactional
    public RecurringExpenses getRecExpById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public List<RecurringExpenses> getAllRecExp() {
        return repository.findAll();
    }

    @Override
    public void deleteReqExp(Long id) throws Exception {
        RecurringExpenses reqExp = repository.findById(id).orElse(null);
        if(reqExp == null){
            throw new Exception("The recurring expenses id doesnt exist.");
        }
        repository.deleteById(id);

    }

    @Override
    @Transactional
    public RecurringExpenses updateRecExp(Long id, RecurringExpenses request) throws Exception {

        RecurringExpenses recExp = getRecExpById(id);
        if(recExp == null){
            throw new Exception("not found");
        }

        recExp.setUser(request.getUser());
        recExp.setInitialDate(request.getInitialDate());
        recExp.setFinalDate(request.getFinalDate());
        recExp.setAmount(request.getAmount());
        recExp.setDescription(request.getDescription());
        recExp.setFrequency(request.getFrequency());
        recExp.setPaymentDate(request.getPaymentDate());
        return recExp;
    }
}
