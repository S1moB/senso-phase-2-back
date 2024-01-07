package com.senso.mboukhenaif.service.mapper;

import com.senso.mboukhenaif.dto.CategoryDto;
import com.senso.mboukhenaif.entities.Category;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Named(value = "getCategoryFromEntity")
    CategoryDto getCategoryFromEntity(Category category);
    @IterableMapping(qualifiedByName = "getCategoryFromEntity")
    List<CategoryDto> getCategoriesFromEntity(List<Category> categories);
    Category getCategoryEntityFromDto(CategoryDto category);
}
