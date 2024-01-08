package com.senso.mboukhenaif.service.impl;

import com.senso.mboukhenaif.dto.ProjectDto;
import com.senso.mboukhenaif.entities.Category;
import com.senso.mboukhenaif.entities.Project;
import com.senso.mboukhenaif.exception.SensoException;
import com.senso.mboukhenaif.repository.BudgetRepository;
import com.senso.mboukhenaif.repository.CategoryRepository;
import com.senso.mboukhenaif.repository.ProjectRepository;
import com.senso.mboukhenaif.repository.UserRepository;
import com.senso.mboukhenaif.service.ProjectService;
import com.senso.mboukhenaif.service.mapper.ProjectMapper;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {
    private ProjectMapper projectMapper;
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    private BudgetRepository budgetRepository;
    private ProjectRepository projectRepository;

    @Override
    public ProjectDto saveProject(ProjectDto projectDto) {
        var project = projectMapper.getProjectEntityFromDto(projectDto);
        handleExternalTableAssociated(project);
        return projectMapper.getProjectFromEntity(projectRepository.save(project));
    }

    private void handleExternalTableAssociated(Project project) {
        if (project.getAssignedUser() != null)
            project.setAssignedUser(userRepository.findById(project.getAssignedUser().getUserId())
                    .orElse(project.getAssignedUser()));
        if(project.getProjectBudget() != null)
            project.setProjectBudget(budgetRepository.findById(project.getProjectBudget().getBudgetCode())
                .orElse(project.getProjectBudget()));
        project.setProjectCategory(categoryRepository.findById(Optional.ofNullable(project.getProjectCategory())
                        .orElseGet(Category::new).getCategoryCode())
                .orElse(project.getProjectCategory()));
    }

    @Override
    public void deleteProject(String projectId) throws SensoException {
        var project = projectRepository.getReferenceById(projectId);
        if (project.getProjectBudget() != null)
            throw new SensoException("ERR:: you can't delete a project with a budget");
        projectRepository.delete(project);
    }

    @Override
    public ProjectDto getProject(String projectId) {
        return projectMapper.getProjectFromEntity(projectRepository.getReferenceById(projectId));
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        return projectMapper.getProjectsFromEntity(projectRepository.findAll());
    }

    @Override
    public List<ProjectDto> getAllActiveProjects() {
        return projectMapper.getProjectsFromEntity(projectRepository.findallActiveProjects(new Date()));
    }

    @Override
    public List<ProjectDto> getAllProjectsAssignedToUser(String userId) {
        var assignedUser = userRepository.getReferenceById(userId);
        return projectMapper.getProjectsFromEntity(projectRepository.findProjectsByAssignedUser(assignedUser));
    }

    public ProjectDto updateProject(ProjectDto updatedProjectDto) {
        var existingProject = projectRepository.findById(updatedProjectDto.getProjectId())
                .orElseThrow(() -> new EntityNotFoundException("Project not found with id: " + updatedProjectDto.getProjectId()));
        projectMapper.updateFromDto(updatedProjectDto, existingProject);
        return projectMapper.getProjectFromEntity(projectRepository.save(existingProject));
    }

    @Override
    public List<ProjectDto> getAllProjectsOfCategory(String categoryId) {
        var category = categoryRepository.getReferenceById(categoryId);
        return projectMapper.getProjectsFromEntity(projectRepository.findProjectsByProjectCategory(category));
    }

    @Autowired
    public void setProjectMapper(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Autowired
    public void setBudgetRepository(BudgetRepository budgetRepository) {
        this.budgetRepository = budgetRepository;
    }

}
