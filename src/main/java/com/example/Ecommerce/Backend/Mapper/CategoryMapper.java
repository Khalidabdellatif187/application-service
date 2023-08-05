package com.example.Ecommerce.Backend.Mapper;


import com.example.Ecommerce.Backend.Dto.CategoryDto;
import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDto toCategoryDto(CategoryEntity categoryEntity);

    CategoryEntity toCategoryEntity(CategoryDto categoryDto);

    List<CategoryDto> toListOfCategoriesDtos(List<CategoryEntity> categoryEntities);

    @Mapping(target = "id", ignore = true)
    void updateCategoryEntityFromDto(CategoryDto categoryDto , @MappingTarget CategoryEntity categoryEntity);
}
