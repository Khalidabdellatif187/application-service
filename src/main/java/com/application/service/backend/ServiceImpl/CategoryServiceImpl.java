package com.application.service.backend.ServiceImpl;

import com.application.service.backend.Dto.CategoryDto;
import com.application.service.backend.Entity.CategoryEntity;
import com.application.service.backend.Exceptions.ResourceNotFoundExceptions;
import com.application.service.backend.Mapper.CategoryMapper;
import com.application.service.backend.Repository.CategoryRepository;
import com.application.service.backend.Service.CategoryService;
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
