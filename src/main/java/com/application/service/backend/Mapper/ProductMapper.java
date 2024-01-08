package com.application.service.backend.Mapper;


import com.application.service.backend.Entity.ProductEntity;
import com.application.service.backend.Dto.ProductDto;
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
