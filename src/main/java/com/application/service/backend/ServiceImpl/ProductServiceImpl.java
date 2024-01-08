package com.application.service.backend.ServiceImpl;


import com.application.service.backend.Dto.CategoryDto;
import com.application.service.backend.Dto.ProductDto;
import com.application.service.backend.Entity.CategoryEntity;
import com.application.service.backend.Entity.ProductEntity;
import com.application.service.backend.Mapper.ProductMapper;
import com.application.service.backend.Projection.ProductsDtoProjection;
import com.application.service.backend.Repository.ProductRepository;
import com.application.service.backend.Service.ProductService;
import com.application.service.backend.Exceptions.ResourceNotFoundExceptions;
import com.application.service.backend.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final ProductMapper productMapper;

    @Override
    public ProductDto insert(ProductDto productDto) {
        ProductEntity productEntity = productMapper.toProductEntity(productDto);
        CategoryEntity category = categoryService.findByCatgoryName(productDto.getCategoryName());
        if (category != null && category.getCategoryName() != null){
            productEntity.setCategory(category);
        } else {

            throw new ResourceNotFoundExceptions("Category" , "Category Name" , category.getCategoryName());
        }
        ProductEntity savedProduct = productRepository.save(productEntity);
        return productMapper.toProductDto(savedProduct);

    }

    @Override
    public List<ProductDto> getProductsByCategoryId(Long categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        List<ProductEntity> productEntities = null;
        if (categoryDto != null){
             productEntities = productRepository.getProductsByCategoryId(categoryId);
        }
        return productMapper.toListOfProductsDtos(productEntities);
    }

    @Override
    public ProductDto update(ProductDto productDto, Long productId) {
        ProductEntity productEntity = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundExceptions("product", "id", productId));
        productMapper.updateProductEntityFromProductDto(productDto, productEntity);
        CategoryEntity category = categoryService.findByCatgoryName(productDto.getCategoryName());
        if (category != null && productDto.getCategoryName() != null) {
            productEntity.setCategory(category);
        } else {
            throw new ResourceNotFoundExceptions("category" , "categoryName" , productDto.getCategoryName());
        }
        ProductEntity updatedProduct = productRepository.save(productEntity);
        return productMapper.toProductDto(updatedProduct);
    }


    @Override
    public List<ProductsDtoProjection> getProductsByCategoryName(String categoryName) {
        List<ProductsDtoProjection> productEntities = null;
        if (categoryName != null){
            productEntities = productRepository.getProductsByCategoryName(categoryName);
        } else {
            throw new ResourceNotFoundExceptions("category" , "categoryName" , categoryName);
        }
        return productEntities;
    }

    @Override
    public ProductDto getProductByCategoryId(Long productId, Long categoryId) {
        CategoryDto category = categoryService.getCategoryById(categoryId);
        ProductEntity productEntity = productRepository.findByIdAndCategoryId(productId , category.getId());
        if (productEntity == null){
            throw new ResourceNotFoundExceptions("product" , "productId" , productId);
        }
        if (category == null){
            throw new ResourceNotFoundExceptions("category" , "categoryId" , categoryId);
        }
        return productMapper.toProductDto(productEntity);
    }

    @Override
    public ProductDto getProductByCategoryName(Long productId, String categoryName) {
        CategoryEntity category = categoryService.findByCatgoryName(categoryName);
        ProductEntity productEntity = productRepository.findByIdAndCategoryCategoryName(productId , category.getCategoryName());
        if (productEntity == null){
            throw new ResourceNotFoundExceptions("product" , "productId" , productId);
        }
        if (category == null){
            throw new ResourceNotFoundExceptions("category" , "categoryName" , categoryName);
        }
        return productMapper.toProductDto(productEntity);
    }


}
