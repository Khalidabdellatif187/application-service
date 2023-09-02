package com.example.Ecommerce.Backend.Service;

import com.example.Ecommerce.Backend.Dto.ProductDto;
import com.example.Ecommerce.Backend.Entity.ProductEntity;
import com.example.Ecommerce.Backend.Projection.GetProductsByCategoryName;

import java.util.List;

public interface ProductService {

    public ProductDto  insert(ProductDto productDto);

    public List<ProductDto> getProductsByCategoryId(Long categoryId);

    public ProductDto update(ProductDto productDto , Long id);

    public List<GetProductsByCategoryName> getProductsByCategoryName(String categoryName);



}
