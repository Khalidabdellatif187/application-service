package com.example.Ecommerce.Backend.Repository;

import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CategoryRepository extends JpaRepository<CategoryEntity , Long> {


    public CategoryEntity findByCategoryName(String categoryName);






}
