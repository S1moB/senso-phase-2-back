package com.senso.mboukhenaif.repository;

import com.senso.mboukhenaif.entities.Category;
import com.senso.mboukhenaif.entities.Project;
import com.senso.mboukhenaif.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, String> {
    List<Project> findProjectsByProjectCategory(Category category);
    List<Project> findProjectsByAssignedUser(User user);
    @Query("from project_senso where startDate <= :datenow AND endDate >= :datenow")
    List<Project> findallActiveProjects(@Param("datenow") Date date);
}
