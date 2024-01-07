package com.senso.mboukhenaif.service.impl;

import com.senso.mboukhenaif.dto.CategoryDto;
import com.senso.mboukhenaif.repository.CategoryRepository;
import com.senso.mboukhenaif.service.CategoryService;
import com.senso.mboukhenaif.service.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryMapper.getCategoriesFromEntity(categoryRepository.findAll());
    }
    @Override
    public CategoryDto saveCategory(CategoryDto categoryDto) {
        return categoryMapper.getCategoryFromEntity(categoryRepository.save(categoryMapper.getCategoryEntityFromDto(categoryDto)));
    }
    @Autowired
    public void setCategoryMapper(CategoryMapper categoryMapper) {
        this.categoryMapper = categoryMapper;
    }

    @Autowired
    public void setCategoryRepository(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

}
