package com.senso.mboukhenaif.service.impl;

import com.senso.mboukhenaif.dto.CategoryDto;
import com.senso.mboukhenaif.entities.Category;
import com.senso.mboukhenaif.repository.CategoryRepository;
import com.senso.mboukhenaif.service.mapper.CategoryMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {

    private CategoryServiceImpl categoryService;
    private CategoryMapper categoryMapper;
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setUp() {
        categoryMapper = Mappers.getMapper(CategoryMapper.class);
        categoryRepository = mock(CategoryRepository.class);
        categoryService = new CategoryServiceImpl();
        categoryService.setCategoryMapper(categoryMapper);
        categoryService.setCategoryRepository(categoryRepository);
    }

    @Test
    void shouldReturnListOfCategoryDtos() {
        // Given
        var categoryEntity = new Category();
        categoryEntity.setCategoryCode("category1");
        var categoryEntities = Collections.singletonList(categoryEntity);

        when(categoryRepository.findAll()).thenReturn(categoryEntities);

        // When
        var categoryDtos = categoryService.getAllCategories();

        // Then
        assertEquals(categoryEntities.size(), categoryDtos.size());
    }

    @Test
    void saveCategory_shouldSaveCategoryEntity() {
        // Given
        var categoryDto = new CategoryDto();
        categoryDto.setCategoryCode("category1");
        var savedCategoryEntity = categoryMapper.getCategoryEntityFromDto(categoryDto);

        when(categoryRepository.save(any(Category.class))).thenReturn(savedCategoryEntity);

        // When
        var savedCategoryDto = categoryService.saveCategory(categoryDto);

        // Then
        assertEquals(categoryDto.getCategoryCode(), savedCategoryDto.getCategoryCode());
    }
}
