package com.example.Ecommerce.Backend.Mapper;


import com.example.Ecommerce.Backend.Dto.ProductDto;
import com.example.Ecommerce.Backend.Entity.ProductEntity;
import org.apache.catalina.LifecycleState;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {



    @Mapping(source = "category.categoryName" , target = "categoryName")
    ProductDto toProductDto(ProductEntity productEntity);

    @Mapping(target = "category.categoryName" , source = "categoryName")
    ProductEntity toProductEntity(ProductDto productDto);

    List<ProductDto> toListOfProductsDtos(List<ProductEntity> productEntityList);

    @Mapping(target =  "id" , ignore = true)
    void updateProductEntityFromProductDto(ProductDto productDto , @MappingTarget ProductEntity productEntity);


}
