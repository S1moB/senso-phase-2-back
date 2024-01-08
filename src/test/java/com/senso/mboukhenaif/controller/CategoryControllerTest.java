package com.senso.mboukhenaif.controller;

import com.senso.mboukhenaif.dto.CategoryDto;
import com.senso.mboukhenaif.service.CategoryService;
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
import static org.mockito.Mockito.when;

class CategoryControllerTest {

    @InjectMocks
    private CategoryController categoryController;

    @Mock
    private CategoryService categoryService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllCategories() {
        // Given
        var expectedCategories = Arrays.asList(new CategoryDto(), new CategoryDto());

        // When
        when(categoryService.getAllCategories()).thenReturn(expectedCategories);
        ResponseEntity<List<CategoryDto>> responseEntity = categoryController.getAllCategories();

        // Then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(expectedCategories, responseEntity.getBody());
    }

    @Test
    void testInsertCategory() {
        // Given
        var categoryDto = new CategoryDto();
        var createdCategory = new CategoryDto();

        // When
        when(categoryService.saveCategory(categoryDto)).thenReturn(createdCategory);
        ResponseEntity<CategoryDto> responseEntity = categoryController.insertCategory(categoryDto);

        // Then
        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(createdCategory, responseEntity.getBody());
    }
}
