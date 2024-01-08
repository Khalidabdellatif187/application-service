package com.application.service.backend.Repository;

import com.application.service.backend.Entity.ProductEntity;
import com.application.service.backend.Projection.ProductsDtoProjection;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository <ProductEntity, Long> {

     public List<ProductEntity> getProductsByCategoryId(Long categoryId);

     public ProductEntity findByIdAndCategoryId(Long productId , Long categoryId);

     public ProductEntity findByIdAndCategoryCategoryName(Long id , @Param("categoryName") String categoryName);

     @Query(value = "SELECT pe.id AS id ,pe.name AS productName, pe.details AS productDetails, pe.imgUrl AS productImage, ce.categoryName As categoryName " +
             "FROM ProductEntity pe " +
             "JOIN pe.category ce " +
             "WHERE ce.categoryName =:categoryName")
     public List<ProductsDtoProjection> getProductsByCategoryName(@Param("categoryName") String categoryName);


}
