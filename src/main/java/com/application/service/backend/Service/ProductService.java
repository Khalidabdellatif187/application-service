package com.application.service.backend.Service;

import com.application.service.backend.Dto.ProductDto;
import com.application.service.backend.Projection.ProductsDtoProjection;

import java.util.List;

public interface ProductService {

    public ProductDto insert(ProductDto productDto);

    public List<ProductDto> getProductsByCategoryId(Long categoryId);

    public ProductDto update(ProductDto productDto , Long id);

    public List<ProductsDtoProjection> getProductsByCategoryName(String categoryName);

//    public Long deleteProduct(Long productId);

    public ProductDto getProductByCategoryId(Long productId , Long categoryId);

    public ProductDto getProductByCategoryName(Long productId , String categoryName);



}
