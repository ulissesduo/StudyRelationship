package com.inn.cafe2.Service;

import com.inn.cafe2.DTO.Request.FutGoalsRequest;
import com.inn.cafe2.Entity.FutureGoals;
import com.inn.cafe2.Repository.IFutGoalsRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FutGoalsService implements IFutGoalsService{

    @Autowired
    private IFutGoalsRepository futgoalsRepository;

    @Override
    @Transactional
    public FutureGoals createFutGoals(FutureGoals futgoals) {

        return futgoalsRepository.save(futgoals);
    }
}
