package com.example.Ecommerce.Backend.Service;

import com.example.Ecommerce.Backend.Dto.ProductDto;
import com.example.Ecommerce.Backend.Entity.ProductEntity;

import java.util.List;

public interface ProductService {

    public ProductDto insert(ProductDto productDto);

    public List<ProductDto> getProductsByCategoryId(Long categoryId);



}
