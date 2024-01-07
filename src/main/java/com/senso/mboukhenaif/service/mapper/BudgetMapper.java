package com.senso.mboukhenaif.service.mapper;

import com.senso.mboukhenaif.dto.BudgetDto;
import com.senso.mboukhenaif.entities.Budget;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BudgetMapper {
    @Named(value = "getBudgetFromEntity")
    BudgetDto getBudgetFromEntity(Budget budget);
    @IterableMapping(qualifiedByName = "getBudgetFromEntity")
    List<BudgetDto> getBudgetsFromEntity(List<Budget> budgets);
    Budget getBudgetEntityFromDto(BudgetDto category);
}
