package com.inn.cafe2.Repository;

import com.inn.cafe2.Entity.RecurringExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecurringExpenses extends JpaRepository<RecurringExpenses, Long> {
}
