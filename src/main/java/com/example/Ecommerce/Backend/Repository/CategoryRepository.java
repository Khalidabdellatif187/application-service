package com.example.Ecommerce.Backend.Repository;

import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



public interface CategoryRepository extends JpaRepository<CategoryEntity , Long> {


}
