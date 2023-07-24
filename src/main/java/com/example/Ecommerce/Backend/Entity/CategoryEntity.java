package com.example.Ecommerce.Backend.Entity;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="category")
public class CategoryEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column
    @NotEmpty(message = "Category name cannot be empty")
    @Size(min = 2, message = "Category name must have at least two characters")
    private String categoryName;

    @Column
    @NotEmpty(message = "Description cannot be empty")
    @Size(min = 2 , message = "Description must have at least two chracters")
    private String description;

    @Column
    @NotEmpty(message = "ImageURL cannot be empty")
    @Pattern(regexp = "^https?://.+\\..+$", message = "Invalid image URL format")
    private String imageUrl;
}
