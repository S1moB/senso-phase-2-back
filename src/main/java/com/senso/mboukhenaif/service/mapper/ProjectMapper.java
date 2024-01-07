package com.senso.mboukhenaif.service.mapper;

import com.senso.mboukhenaif.dto.ProjectDto;
import com.senso.mboukhenaif.entities.Project;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    @Named(value = "getProjectFromEntity")
    ProjectDto getProjectFromEntity(Project project);
    @IterableMapping(qualifiedByName = "getProjectFromEntity")
    List<ProjectDto> getProjectsFromEntity(List<Project> projects);
    Project getProjectEntityFromDto(ProjectDto category);
    void updateFromDto(ProjectDto projectDto, @MappingTarget Project project);
}
