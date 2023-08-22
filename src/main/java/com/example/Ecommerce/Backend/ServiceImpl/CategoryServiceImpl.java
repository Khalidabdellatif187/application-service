package com.example.Ecommerce.Backend.ServiceImpl;

import com.example.Ecommerce.Backend.Dto.CategoryDto;
import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import com.example.Ecommerce.Backend.Exceptions.ResourceNotFoundExceptions;
import com.example.Ecommerce.Backend.Mapper.CategoryMapper;
import com.example.Ecommerce.Backend.Repository.CategoryRepository;
import com.example.Ecommerce.Backend.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
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

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() ->  new ResourceNotFoundExceptions("CategoryEntity" , "id" , categoryId));
        return categoryMapper.toCategoryDto(categoryEntity);
    }

    @Override
    public List<CategoryDto> findAllCategories() {
        List<CategoryEntity> getAllCategories = categoryRepository.findAll();
        return categoryMapper.toListOfCategoriesDtos(getAllCategories);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Long categoryId) {
        CategoryEntity categoryEntity = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("category" , "id" , categoryId));

        categoryMapper.updateCategoryEntityFromDto(categoryDto , categoryEntity);
        CategoryEntity updatedCategory = categoryRepository.save(categoryEntity);
        return categoryMapper.toCategoryDto(updatedCategory);
    }

    @Override
    public CategoryEntity findByCatgoryName(String categoryName) {
        return categoryRepository.findByCategoryName(categoryName);
    }

    @Override
    public CategoryDto deleteById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("category" , "id" , id));
        categoryRepository.delete(categoryEntity);
        return categoryMapper.toCategoryDto(categoryEntity);
    }


}
