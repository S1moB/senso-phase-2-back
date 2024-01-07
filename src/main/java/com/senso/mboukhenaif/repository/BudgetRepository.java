package com.senso.mboukhenaif.repository;

import com.senso.mboukhenaif.entities.Budget;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BudgetRepository extends JpaRepository<Budget, String> {
}
