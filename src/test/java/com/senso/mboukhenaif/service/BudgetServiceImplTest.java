package com.senso.mboukhenaif.service;

import com.senso.mboukhenaif.dto.BudgetDto;
import com.senso.mboukhenaif.entities.Budget;
import com.senso.mboukhenaif.repository.BudgetRepository;
import com.senso.mboukhenaif.service.impl.BudgetServiceImpl;
import com.senso.mboukhenaif.service.mapper.BudgetMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

class BudgetServiceImplTest {

    @Mock
    private BudgetMapper budgetMapper;

    @Mock
    private BudgetRepository budgetRepository;

    @InjectMocks
    private BudgetServiceImpl budgetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnListOfBudgetDtos() {
        // Given
        when(budgetRepository.findAll()).thenReturn(Collections.emptyList());

        // When
        var result = budgetService.getAllBudgets();

        // Then
        assertEquals(0, result.size());
    }

    @Test
    void shouldReturnSavedBudgetDto() {
        // Given
        var inputDto = new BudgetDto();
        var savedDto = new BudgetDto();
        when(budgetMapper.getBudgetFromEntity(any())).thenReturn(savedDto);
        when(budgetMapper.getBudgetEntityFromDto(inputDto)).thenReturn(new Budget()); // Mock your entity conversion

        // When
        BudgetDto result = budgetService.saveBudget(inputDto);

        // Then
        assertEquals(savedDto, result);
    }
}
