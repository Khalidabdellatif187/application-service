package com.example.Ecommerce.Backend.Dto;


import jakarta.persistence.Column;
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
public class CategoryDto {


    private Long id;
    @NotEmpty(message = "Category name cannot be empty")
    @Size(min = 2, message = "Category name must have at least two characters")
    private String categoryName;
    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 2 , message = "Description must have at least two chracters")
    private String description;
    @NotEmpty(message = "ImageURL cannot be empty")
    @Pattern(regexp = "^https?://.+\\..+$", message = "Invalid image URL format")
    private String imageUrl;

}
