package com.senso.mboukhenaif.service;

import com.senso.mboukhenaif.dto.ProjectDto;
import com.senso.mboukhenaif.entities.Category;
import com.senso.mboukhenaif.entities.Project;
import com.senso.mboukhenaif.repository.BudgetRepository;
import com.senso.mboukhenaif.repository.CategoryRepository;
import com.senso.mboukhenaif.repository.ProjectRepository;
import com.senso.mboukhenaif.repository.UserRepository;
import com.senso.mboukhenaif.service.impl.ProjectServiceImpl;
import com.senso.mboukhenaif.service.mapper.ProjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ProjectServiceImplTest {

    @Mock
    private ProjectMapper projectMapper;

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private BudgetRepository budgetRepository;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnSavedProjectDto() {
        // Given
        var projectDto = new ProjectDto();
        var projectEntity = new Project();
        when(projectMapper.getProjectEntityFromDto(projectDto)).thenReturn(projectEntity);
        when(projectRepository.save(any())).thenReturn(projectEntity);
        when(projectMapper.getProjectFromEntity(projectEntity)).thenReturn(projectDto);

        // When
        var result = projectService.saveProject(projectDto);

        // Then
        assertEquals(projectDto, result);
    }


    @Test
    void shouldReturnProjectDto() {
        // Given
        String projectId = "project1";
        Project projectEntity = new Project();
        ProjectDto projectDto = new ProjectDto();
        when(projectRepository.getReferenceById(projectId)).thenReturn(projectEntity);
        when(projectMapper.getProjectFromEntity(projectEntity)).thenReturn(projectDto);

        // When
        ProjectDto result = projectService.getProject(projectId);

        // Then
        assertEquals(projectDto, result);
    }

    @Test
    void shouldReturnEmptyListOfProjectDtos() {
        // Given
        var projectEntities = Collections.singletonList(new Project());
        var projectDtos = Collections.singletonList(new ProjectDto());


        // When
        when(projectRepository.findAll()).thenReturn(projectEntities);
        when(projectMapper.getProjectsFromEntity(projectEntities)).thenReturn(projectDtos);
        var result = projectService.getAllProjects();

        // Then
        assertEquals(projectDtos, result);
    }

    @Test
    void shouldReturnUpdatedProjectDto() {
        // Given
        var updatedProjectDto = new ProjectDto();
        var existingProject = new Project();

        // When
        when(projectRepository.findById(updatedProjectDto.getProjectId())).thenReturn(Optional.of(existingProject));
        when(projectRepository.save(existingProject)).thenReturn(existingProject);
        when(projectMapper.getProjectFromEntity(existingProject)).thenReturn(updatedProjectDto);
        var result = projectService.updateProject(updatedProjectDto);

        // Then
        assertEquals(updatedProjectDto, result);
    }

    @Test
    void shouldReturnListOfProjectDtos() {
        // Given
        var categoryId = "category1";
        var category = new Category();
        var projectEntities = Collections.singletonList(new Project());
        var projectDtos = Collections.singletonList(new ProjectDto());

        // When
        when(categoryRepository.getReferenceById(categoryId)).thenReturn(category);
        when(projectRepository.findProjectsByProjectCategory(any(Category.class))).thenReturn(projectEntities);
        when(projectMapper.getProjectsFromEntity(projectEntities)).thenReturn(projectDtos);
        var result = projectService.getAllProjectsOfCategory(categoryId);

        // Then
        assertEquals(projectDtos, result);
    }
}
