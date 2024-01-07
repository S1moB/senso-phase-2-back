package com.senso.mboukhenaif.service;

import com.senso.mboukhenaif.dto.ProjectDto;
import com.senso.mboukhenaif.exception.SensoException;

import java.util.List;


public interface ProjectService {
    ProjectDto saveProject(final ProjectDto projectDto);
    ProjectDto updateProject(final ProjectDto updatedProjectDto);
    ProjectDto getProject(final String projectId);
    void deleteProject(final String projectId) throws SensoException;
    List<ProjectDto> getAllProjects();
    List<ProjectDto> getAllTheniveProjects();
    List<ProjectDto> getAllProjectsAssignedToUser(String userId);
    List<ProjectDto> getAllProjectsOfCategory(String categoryCode);
}
