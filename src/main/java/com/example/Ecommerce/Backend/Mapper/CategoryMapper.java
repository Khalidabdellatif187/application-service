package com.example.Ecommerce.Backend.Mapper;


import com.example.Ecommerce.Backend.Dto.CategoryDto;
import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {

    CategoryDto toCategoryDto(CategoryEntity categoryEntity);

    CategoryEntity toCategoryEntity(CategoryDto categoryDto);

}
