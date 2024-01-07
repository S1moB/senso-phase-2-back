package com.senso.mboukhenaif.service.mapper;

import com.senso.mboukhenaif.dto.BudgetDto;
import com.senso.mboukhenaif.entities.Budget;
import com.senso.mboukhenaif.service.impl.BudgetServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class BudgetMapperTest {

    @Mock
    private BudgetMapper budgetMapper;

    @InjectMocks
    private BudgetServiceImpl budgetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldMapToBudgetDto() {
        // Given
        var budgetEntity = new Budget();
        var budgetDto = new BudgetDto();
        when(budgetMapper.getBudgetFromEntity(any())).thenReturn(budgetDto);

        // When
        var result = budgetMapper.getBudgetFromEntity(budgetEntity);

        // Then
        assertEquals(budgetDto, result);
        verify(budgetMapper, times(1)).getBudgetFromEntity(budgetEntity);
    }

    @Test
    void shouldMapToListOfBudgetDtos() {
        // Given
        var budgetEntities = Collections.singletonList(new Budget());
        var budgetDtos = Collections.singletonList(new BudgetDto());
        when(budgetMapper.getBudgetsFromEntity(any())).thenReturn(budgetDtos);

        // When
        var result = budgetMapper.getBudgetsFromEntity(budgetEntities);

        // Then
        assertEquals(budgetDtos, result);
    }

    @Test
    void shouldMapToBudgetEntity() {
        // Given
        var budgetDto = new BudgetDto();
        var budgetEntity = new Budget();
        when(budgetMapper.getBudgetEntityFromDto(any())).thenReturn(budgetEntity);

        // When
        var result = budgetMapper.getBudgetEntityFromDto(budgetDto);

        // Then
        assertEquals(budgetEntity, result);
        verify(budgetMapper, times(1)).getBudgetEntityFromDto(budgetDto);
    }
}
