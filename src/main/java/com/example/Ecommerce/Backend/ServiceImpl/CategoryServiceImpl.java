package com.example.Ecommerce.Backend.ServiceImpl;

import com.example.Ecommerce.Backend.Dto.CategoryDto;
import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import com.example.Ecommerce.Backend.Mapper.CategoryMapper;
import com.example.Ecommerce.Backend.Repository.CategoryRepository;
import com.example.Ecommerce.Backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }


    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

       CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(categoryDto);
       categoryEntity = categoryRepository.save(categoryEntity);
       return categoryMapper.toCategoryDto(categoryEntity);

    }
}
