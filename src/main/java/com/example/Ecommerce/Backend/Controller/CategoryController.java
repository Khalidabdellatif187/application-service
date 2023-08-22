package com.example.Ecommerce.Backend.Controller;


import com.example.Ecommerce.Backend.Dto.CategoryDto;
import com.example.Ecommerce.Backend.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories(){
        return new ResponseEntity<>(categoryService.findAllCategories(),HttpStatus.OK);
    }


    @PostMapping("/add")
    public ResponseEntity<CategoryDto> createCategory(@Valid@RequestBody CategoryDto categoryDto){
        return new ResponseEntity<>(categoryService.createCategory(categoryDto) , HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable(name = "id") Long id){
        return new ResponseEntity<>(categoryService.getCategoryById(id) , HttpStatus.OK);
    }


    @PutMapping("update/{id}")
    public ResponseEntity<CategoryDto> updateCategoryById(@Valid@RequestBody CategoryDto categoryDto , @PathVariable(name = "id") Long id){
        return new ResponseEntity<>(categoryService.updateCategory(categoryDto , id) , HttpStatus.CREATED);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<CategoryDto> deleteById(@PathVariable(name="id") Long id){
        return new ResponseEntity<>(categoryService.deleteById(id) , HttpStatus.OK);
    }









}
