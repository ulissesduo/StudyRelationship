package com.inn.cafe2.Repository;

import com.inn.cafe2.Entity.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExpensesRepository extends JpaRepository<Expenses, Long> {
}
