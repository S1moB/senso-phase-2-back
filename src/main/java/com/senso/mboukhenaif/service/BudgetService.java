package com.senso.mboukhenaif.service;

import com.senso.mboukhenaif.dto.BudgetDto;

import java.util.List;


public interface BudgetService {
    BudgetDto saveBudget(final BudgetDto budgetDto);
    List<BudgetDto> getAllBudgets();
}
