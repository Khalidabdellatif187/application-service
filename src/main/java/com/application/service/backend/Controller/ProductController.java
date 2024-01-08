package com.application.service.backend.Controller;


import com.application.service.backend.Projection.ProductsDtoProjection;
import com.application.service.backend.Dto.ProductDto;
import com.application.service.backend.Service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
    public ResponseEntity<List<ProductsDtoProjection>> getProductsByCategoryName(@RequestParam(value = "categoryName" , required = true)
                                                                      String categoryName){
        return new ResponseEntity<>(productService.getProductsByCategoryName(categoryName) , HttpStatus.OK);
    }

    @GetMapping("/{productId}/{categoryId}")
    public ResponseEntity<ProductDto> getProductByCategoryId(@PathVariable(value = "productId") Long productId ,
                                                             @PathVariable(value = "categoryId") Long categoryId){
        return new ResponseEntity<>(productService.getProductByCategoryId(productId , categoryId) , HttpStatus.OK);
    }

    @GetMapping("/with-category-name/{productId}")
    public ResponseEntity<ProductDto> getProductByCategoryName(@PathVariable(value = "productId") Long productId ,
                                                               @RequestParam(value = "categoryName") String categoryName){
        return new ResponseEntity<>(productService.getProductByCategoryName(productId , categoryName) , HttpStatus.OK);
    }
}
