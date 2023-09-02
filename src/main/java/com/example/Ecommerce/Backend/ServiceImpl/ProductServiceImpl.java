package com.example.Ecommerce.Backend.ServiceImpl;


import com.example.Ecommerce.Backend.Dto.CategoryDto;
import com.example.Ecommerce.Backend.Dto.ProductDto;
import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import com.example.Ecommerce.Backend.Entity.ProductEntity;
import com.example.Ecommerce.Backend.Exceptions.ResourceNotFoundExceptions;
import com.example.Ecommerce.Backend.Mapper.ProductMapper;
import com.example.Ecommerce.Backend.Projection.GetProductsByCategoryName;
import com.example.Ecommerce.Backend.Repository.ProductRepository;
import com.example.Ecommerce.Backend.Service.CategoryService;
import com.example.Ecommerce.Backend.Service.ProductService;
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
    public List<GetProductsByCategoryName> getProductsByCategoryName(String categoryName) {
        List<GetProductsByCategoryName> productEntities = null;
        if (categoryName != null){
            productEntities = productRepository.getProductsByCategoryName(categoryName);
        } else {
            throw new ResourceNotFoundExceptions("category" , "categoryName" , categoryName);
        }
        return productEntities;
    }


}
