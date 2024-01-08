package com.senso.mboukhenaif.controller;

import com.senso.mboukhenaif.dto.ProjectDto;
import com.senso.mboukhenaif.exception.SensoException;
import com.senso.mboukhenaif.service.ProjectService;
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
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ProjectControllerTest {

    @InjectMocks
    private ProjectController projectController;

    @Mock
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllProjects() {
        // Given
        List<ProjectDto> expectedProjects = Arrays.asList(new ProjectDto(), new ProjectDto());

        // When
        when(projectService.getAllProjects()).thenReturn(expectedProjects);
        ResponseEntity<List<ProjectDto>> responseEntity = projectController.getAllProjects();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedProjects, responseEntity.getBody());
    }

    @Test
    void testDeleteProject() throws SensoException {
        // Given
        String projectId = "123";

        // When
        doNothing().when(projectService).deleteProject(projectId);
        ResponseEntity<Void> responseEntity = projectController.deleteProject(projectId);

        // Assert
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
    }
}
