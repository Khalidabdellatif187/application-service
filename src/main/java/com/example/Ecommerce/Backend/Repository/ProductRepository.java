package com.example.Ecommerce.Backend.Repository;

import com.example.Ecommerce.Backend.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <ProductEntity , Long> {

     public List<ProductEntity> getProductsByCategoryId(Long categoryId);
}
