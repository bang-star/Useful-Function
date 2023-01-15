package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@ToString
@Getter
@Setter
@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ToString.Exclude @OneToMany(mappedBy = "product", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<Image> images = new LinkedHashSet<>();

    @ToString.Exclude @OneToMany(mappedBy = "store", cascade = {CascadeType.ALL}, orphanRemoval = true)
    private Set<StoreProduct> storeProducts = new LinkedHashSet<>();

    public void addStoreProduct(StoreProduct storeProduct) {
        storeProduct.setStore(this);
        this.storeProducts.add(storeProduct);
    }

    public void clearStoreProduct() {
        this.storeProducts.clear();
    }

    public void removeStoreProduct(StoreProduct storeProduct) {
        this.storeProducts.remove(storeProduct);
    }

    public void removeStoreProducts(List<StoreProduct> storeProducts) {
        storeProducts.forEach(this.storeProducts::remove);
    }

    public void addImage(Image image){
        image.setStore(this);
        this.images.add(image);
    }
}
