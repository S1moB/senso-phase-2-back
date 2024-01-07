package com.senso.mboukhenaif.repository;

import com.senso.mboukhenaif.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, String> {
}
