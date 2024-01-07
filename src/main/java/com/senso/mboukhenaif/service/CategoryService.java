package com.senso.mboukhenaif.service;

import com.senso.mboukhenaif.dto.CategoryDto;

import java.util.List;


public interface CategoryService {
    CategoryDto saveCategory(final CategoryDto categoryDto);
    List<CategoryDto> getAllCategories();
}
