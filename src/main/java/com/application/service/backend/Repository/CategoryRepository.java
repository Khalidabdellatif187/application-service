package com.application.service.backend.Repository;

import com.application.service.backend.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {


    public CategoryEntity findByCategoryName(String categoryName);








}
