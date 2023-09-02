package com.example.Ecommerce.Backend.Repository;

import com.example.Ecommerce.Backend.Entity.ProductEntity;
import com.example.Ecommerce.Backend.Projection.GetProductsByCategoryName;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository <ProductEntity , Long> {

     public List<ProductEntity> getProductsByCategoryId(Long categoryId);



     @Query(value = "SELECT pe.name AS productName, pe.details AS productDetails, pe.imgUrl AS productImage, ce.categoryName As categoryName " +
             "FROM ProductEntity pe " +
             "JOIN pe.category ce " +
             "WHERE ce.categoryName =:categoryName")
     public List<GetProductsByCategoryName> getProductsByCategoryName(@Param("categoryName") String categoryName);


}
