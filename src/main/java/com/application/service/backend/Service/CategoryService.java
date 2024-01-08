package com.application.service.backend.Service;

import com.application.service.backend.Dto.CategoryDto;
import com.application.service.backend.Entity.CategoryEntity;

import java.util.List;

public interface CategoryService {

    public CategoryDto createCategory(CategoryDto categoryDto);
    public CategoryDto getCategoryById(Long categoryId);
    public List<CategoryDto> findAllCategories();
    public CategoryDto updateCategory(CategoryDto categoryDto,Long categoryId);

    public CategoryEntity findByCatgoryName(String categoryName);
    public CategoryDto deleteById(Long id);






}
