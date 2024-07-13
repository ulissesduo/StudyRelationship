package com.inn.cafe2.Repository;

import com.inn.cafe2.Entity.Fgoal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFgRepository extends JpaRepository<Fgoal, Long> {
}
