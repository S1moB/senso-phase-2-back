package com.senso.mboukhenaif.service.mapper;

import com.senso.mboukhenaif.dto.CategoryDto;
import com.senso.mboukhenaif.entities.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CategoryMapperTest {

    private CategoryMapper categoryMapper;

    @BeforeEach
    void setUp() {
        categoryMapper = Mappers.getMapper(CategoryMapper.class);
    }

    @Test
    void shouldMapToCategoryDto() {
        // Given
        var categoryEntity = new Category();
        categoryEntity.setCategoryCode("category1");

        // When
        var categoryDto = categoryMapper.getCategoryFromEntity(categoryEntity);

        // Then
        assertEquals(categoryEntity.getCategoryCode(), categoryDto.getCategoryCode());
    }

    @Test
    void shouldMapToCategoryDtoList() {
        // Given
        var categoryEntities = Collections.singletonList(new Category());

        // When
        var categoryDtos = categoryMapper.getCategoriesFromEntity(categoryEntities);

        // Then
        assertEquals(categoryEntities.size(), categoryDtos.size());
    }

    @Test
    void shouldMapToCategoryEntity() {
        // Given
        var categoryDto = new CategoryDto();
        categoryDto.setCategoryCode("category1");

        // When
        var categoryEntity = categoryMapper.getCategoryEntityFromDto(categoryDto);

        // Then
        assertEquals(categoryDto.getCategoryCode(), categoryEntity.getCategoryCode());
    }
}
