package com.senso.mboukhenaif.controller;

import com.senso.mboukhenaif.dto.ProjectDto;
import com.senso.mboukhenaif.exception.SensoException;
import com.senso.mboukhenaif.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {
    private ProjectService projectService;

    @GetMapping("/all")
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProject(final @PathVariable String projectId) {
        return ResponseEntity.ok(projectService.getProject(projectId));
    }

    @GetMapping("/allActive")
    public ResponseEntity<List<ProjectDto>> getAllActiveProjects() {
        return ResponseEntity.ok(projectService.getAllActiveProjects());
    }

    @GetMapping("/getByUser/{userId}")
    public ResponseEntity<List<ProjectDto>> getAllProjectsByAssignedUser(@PathVariable String userId) {
        return ResponseEntity.ok(projectService.getAllProjectsAssignedToUser(userId));
    }

    @GetMapping("/getByCategory/{categoryId}")
    public ResponseEntity<List<ProjectDto>> getAllProjectsByCategory(@PathVariable String categoryId) {
        return ResponseEntity.ok(projectService.getAllProjectsOfCategory(categoryId));
    }

    @PostMapping("/")
    public ResponseEntity<ProjectDto> insertProject(final @RequestBody ProjectDto project) {
        var projectCreated = projectService.saveProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(projectCreated);
    }

    @PutMapping("/")
    public ResponseEntity<ProjectDto> updateProject(final @RequestBody ProjectDto project) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.updateProject(project));
    }

    @PostMapping("/all")
    public ResponseEntity<List<ProjectDto>> insertProjectList(final @RequestBody List<ProjectDto> projects) {
        projects.forEach(project -> projectService.saveProject(project));
        return ResponseEntity.status(HttpStatus.CREATED).body(projects);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> deleteProject(final @PathVariable String projectId) throws SensoException {
        projectService.deleteProject(projectId);
        return ResponseEntity.noContent().build();
    }

    @Autowired
    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }
}
