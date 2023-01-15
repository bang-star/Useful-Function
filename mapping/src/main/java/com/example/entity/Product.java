package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Image> images = new LinkedHashSet<>();

    @ToString.Exclude @OneToMany(mappedBy = "product")
    private Set<StoreProduct> storeProducts = new LinkedHashSet<>();

    public void addStoreProduct(StoreProduct storeProduct) {
        storeProduct.setProduct(this);
        this.storeProducts.add(storeProduct);
    }

    public void addImage(Image image){
        image.setProduct(this);
        this.images.add(image);
    }

    public void clearImages() {
        this.images.clear();
    }
}
