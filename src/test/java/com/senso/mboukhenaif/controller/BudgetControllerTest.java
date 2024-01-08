package com.senso.mboukhenaif.controller;

import com.senso.mboukhenaif.dto.BudgetDto;
import com.senso.mboukhenaif.service.BudgetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BudgetControllerTest {

    @InjectMocks
    private BudgetController budgetController;

    @Mock
    private BudgetService budgetService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllBudgets() {
        // Given
        var expectedBudgets = Arrays.asList(new BudgetDto(), new BudgetDto());

        // When
        when(budgetService.getAllBudgets()).thenReturn(expectedBudgets);
        ResponseEntity<List<BudgetDto>> responseEntity = budgetController.getAllBudgets();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedBudgets, responseEntity.getBody());
    }

    @Test
    void testInsertBudget() {
        // Given
        var budgetDto = new BudgetDto();
        var createdBudget = new BudgetDto();

        // When
        when(budgetService.saveBudget(budgetDto)).thenReturn(createdBudget);
        ResponseEntity<BudgetDto> responseEntity = budgetController.insertBudget(budgetDto);

        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdBudget, responseEntity.getBody());
    }
}
