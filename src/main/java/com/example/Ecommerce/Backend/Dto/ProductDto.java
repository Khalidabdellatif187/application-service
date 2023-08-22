package com.example.Ecommerce.Backend.Dto;

import com.example.Ecommerce.Backend.Entity.CategoryEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {


    private Long id;
    @NotEmpty(message = "Product name cannot be empty")
    @Size(min = 2, message = "Product name must have at least two characters")
    private String name;
    @NotEmpty(message = "Product details cannot be empty")
    @Size(min = 10, message = "Product details must have at least ten characters")
    private String details;
    @NotEmpty(message = "ImageURL cannot be empty , Image Url Format Must Like 'http://example.com/image.jpg'")
    @Pattern(regexp = "^https?://.+\\..+$", message = "Invalid image URL format")
    private String imgUrl;
    @NotEmpty(message = "Category Name cannot be empty")
    private String categoryName;

}
