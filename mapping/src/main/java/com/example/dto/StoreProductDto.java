package com.example.dto;

import com.example.entity.StoreProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StoreProductDto {
    private Long id;
    private StoreDto storeDto;
    private ProductDto productDto;

    public static StoreProductDto fromEntity(StoreProduct storeProduct) {
        return new StoreProductDto(
                storeProduct.getId(),
                StoreDto.fromEntity(storeProduct.getStore()),
                ProductDto.fromEntity(storeProduct.getProduct())
        );
    }
}
