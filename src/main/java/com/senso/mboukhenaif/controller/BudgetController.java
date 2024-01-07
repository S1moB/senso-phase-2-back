package com.senso.mboukhenaif.controller;

import com.senso.mboukhenaif.dto.BudgetDto;
import com.senso.mboukhenaif.service.BudgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/budget")
public class BudgetController {
    private BudgetService budgetService;

    @GetMapping("/all")
    public ResponseEntity<List<BudgetDto>> getAllBudgets(){
        return ResponseEntity.ok(budgetService.getAllBudgets());
    }
    @PostMapping("/")
    public ResponseEntity<BudgetDto> insertBudget(final @RequestBody BudgetDto budgetDto){
        var budgetCreated = budgetService.saveBudget(budgetDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(budgetCreated);
    }

    @Autowired
    public void setBudgetService(BudgetService budgetService) {
        this.budgetService = budgetService;
    }
}
