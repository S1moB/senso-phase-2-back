package com.senso.mboukhenaif.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProjectDto {
    private String projectId;
    private Date startDate;
    private Date endDate;
    private UserDto assignedUser;
    private BudgetDto projectBudget;
    private CategoryDto projectCategory;
}
