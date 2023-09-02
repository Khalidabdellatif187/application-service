package com.example.Ecommerce.Backend.Controller;


import com.example.Ecommerce.Backend.Dto.ProductDto;
import com.example.Ecommerce.Backend.Projection.GetProductsByCategoryName;
import com.example.Ecommerce.Backend.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;


    @PostMapping("/add")
    public ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto productDto){

        return new ResponseEntity<ProductDto>(productService.insert(productDto), HttpStatus.CREATED);
    }


    @GetMapping("/{categoryId}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable(name = "categoryId") Long categoryId){
        return new ResponseEntity<>(productService.getProductsByCategoryId(categoryId),HttpStatus.OK);
    }


    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProduct(@Valid@RequestBody ProductDto productDto ,
                                                    @PathVariable(name = "productId") Long productId){
        return new ResponseEntity<>(productService.update(productDto,productId) , HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<GetProductsByCategoryName>> getProductsByCategoryName( @RequestParam(value = "categoryName" , required = true)
                                                                      String categoryName){
        return new ResponseEntity<>(productService.getProductsByCategoryName(categoryName) , HttpStatus.OK);
    }
}
