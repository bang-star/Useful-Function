package com.example.dto;

import com.example.entity.Product;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private Long id;
    private String name;

    public static ProductDto fromEntity(Product product){
        return new ProductDto(
                product.getId(),
                product.getName()
        );
    }
}
