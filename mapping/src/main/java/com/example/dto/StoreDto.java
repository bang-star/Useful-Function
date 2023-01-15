package com.example.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.example.entity.Store;

@NoArgsConstructor
@AllArgsConstructor
public class StoreDto {
    private Long id;
    private String name;

    public static StoreDto fromEntity(Store store){
        return new StoreDto(
                store.getId(),
                store.getName()
        );
    }
}
