package com.example.Ecommerce.Backend.Service;

import com.example.Ecommerce.Backend.Dto.CategoryDto;
import com.example.Ecommerce.Backend.Entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto getCategoryById(Long categoryId);
    public List<CategoryDto> findAllCategories();
    public CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);

    public CategoryEntity findByCatgoryName(String categoryName);
    public CategoryDto deleteById(Long id);






}
