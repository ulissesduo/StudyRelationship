package com.inn.cafe2.Repository;

import com.inn.cafe2.Entity.FutureGoals;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFutGoalsRepository extends JpaRepository<FutureGoals, Long> {
}
