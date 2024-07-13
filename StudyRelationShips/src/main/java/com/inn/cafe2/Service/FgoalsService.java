package com.inn.cafe2.Service;

import com.inn.cafe2.Entity.Expenses;
import com.inn.cafe2.Entity.Fgoal;
import com.inn.cafe2.Repository.IExpensesRepository;
import com.inn.cafe2.Repository.IFgRepository;
import com.inn.cafe2.Repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FgoalsService implements IFutGoalsService{

    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IFgRepository repository;

    @Transactional
    public Fgoal createExpenses(Fgoal fgoal) {
        return repository.save(fgoal);
    }

    @Override
    public Fgoal getFGById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<Fgoal> getAllFG() {
        return repository.findAll();
    }

    @Override
    public void deleteFGById(Long id) throws Exception {
        Fgoal fg = getFGById(id);
        if (fg == null){
            throw new Exception("Expense not found with ID: " + id);
        }

        repository.delete(fg);
    }


}
