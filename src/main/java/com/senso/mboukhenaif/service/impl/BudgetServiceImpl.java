package com.senso.mboukhenaif.service.impl;

import com.senso.mboukhenaif.dto.BudgetDto;
import com.senso.mboukhenaif.repository.BudgetRepository;
import com.senso.mboukhenaif.service.BudgetService;
import com.senso.mboukhenaif.service.mapper.BudgetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BudgetServiceImpl implements BudgetService {
    private BudgetMapper budgetMapper;
    private BudgetRepository budgetRepository;

    @Override
    public List<BudgetDto> getAllBudgets() {
        return budgetMapper.getBudgetsFromEntity(budgetRepository.findAll());
    }
    @Override
    public BudgetDto saveBudget(BudgetDto budgetDto) {
        return budgetMapper.getBudgetFromEntity(budgetRepository.save(budgetMapper.getBudgetEntityFromDto(budgetDto)));
    }
    @Autowired
    public void setBudgetMapper(BudgetMapper budgetMapper) {
        this.budgetMapper = budgetMapper;
    }

    @Autowired
    public void setBudgetRepository(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

}
