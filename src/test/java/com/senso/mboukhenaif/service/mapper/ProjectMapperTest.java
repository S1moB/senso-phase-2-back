package com.senso.mboukhenaif.service.mapper;

import com.senso.mboukhenaif.dto.ProjectDto;
import com.senso.mboukhenaif.entities.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProjectMapperTest {

    private ProjectMapper projectMapper;

    @BeforeEach
    void setUp() {
        projectMapper = Mappers.getMapper(ProjectMapper.class);
    }

    @Test
    void shouldMapToProjectDto() {
        // Given
        var projectEntity = new Project();
        projectEntity.setProjectId("project1");

        // When
        var projectDto = projectMapper.getProjectFromEntity(projectEntity);

        // Then
        assertEquals(projectEntity.getProjectId(), projectDto.getProjectId());
    }

    @Test
    void shouldMapToProjectDtoList() {
        // Given
        var projectEntities = Collections.singletonList(new Project());

        // When
        var projectDtos = projectMapper.getProjectsFromEntity(projectEntities);

        // Then
        assertEquals(projectEntities.size(), projectDtos.size());
    }

    @Test
    void shouldMapToProjectEntity() {
        // Given
        var projectDto = new ProjectDto();
        projectDto.setProjectId("project1");

        // When
        var projectEntity = projectMapper.getProjectEntityFromDto(projectDto);

        // Then
        assertEquals(projectDto.getProjectId(), projectEntity.getProjectId());
    }

    @Test
    void shouldUpdateProjectEntityFromDto() {
        // Given
        var projectDto = new ProjectDto();
        projectDto.setProjectId("project1");

        var existingProject = new Project();
        existingProject.setProjectId("project2");

        // When
        projectMapper.updateFromDto(projectDto, existingProject);

        // Then
        assertEquals(projectDto.getProjectId(), existingProject.getProjectId());
    }
}
