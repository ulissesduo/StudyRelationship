package com.inn.cafe2.Service;

import com.inn.cafe2.DTO.Request.ExpensesRequest;
import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.User;
import com.inn.cafe2.Repository.IExpensesRepository;
import com.inn.cafe2.Repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;

@Service
public class ExpensesService implements IExpensesService{
    @Autowired
    private IExpensesRepository repository;

    @Autowired
    private IUserRepository userRepository;

    @Override
    @Transactional
    public Expenses createExpenses(Expenses exp) {
        return repository.save(exp);
    }

    @Override
    public Expenses updateExpense( Long userId,Long id, ExpensesRequest request) throws Exception {

        Expenses exp = this.getExpenseById(id);
        if(exp == null){
            throw new Exception("There is no expenses with the id " + id);
        }
        Expenses existingExpense = repository.findById(id).orElse(null);
        if (existingExpense == null) {
            throw new Exception("Expense not found with ID: " + id);
        }

        existingExpense.setDescription(request.getDescription());
        existingExpense.setValue(request.getValue());
        if (request.getPaymentDate() != null) {
            existingExpense.setPaymentDate(request.getPaymentDate());
        }
        if (request.getStatusPayment() != null) {
            existingExpense.setStatusPayment(request.getStatusPayment());
        }

        Optional<User> user = userRepository.findById(request.getUserId());
        if(user != null){
            existingExpense.setUser(user.orElse(null));
        }

        return repository.save(existingExpense);

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
