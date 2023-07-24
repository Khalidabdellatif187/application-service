package com.example.Ecommerce.Backend.ServiceImpl;

import com.example.Ecommerce.Backend.Dto.CategoryDto;
import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import com.example.Ecommerce.Backend.Mapper.CategoryMapper;
import com.example.Ecommerce.Backend.Repository.CategoryRepository;
import com.example.Ecommerce.Backend.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;




    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
      CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(categoryDto);
      categoryEntity = categoryRepository.save(categoryEntity);
      return categoryMapper.toCategoryDto(categoryEntity);

    }
}
