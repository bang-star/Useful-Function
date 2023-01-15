package com.example.dto;

import com.example.entity.StoreProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductDto {
    private StoreDto storeDto;
    private ProductDto productDto;

    public static StoreProductDto fromEntity(StoreProduct storeProduct) {
        return new StoreProductDto(
            StoreDto.fromEntity(storeProduct.getStore()),
            ProductDto.fromEntity(storeProduct.getProduct())
        );
    }
}
