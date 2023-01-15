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
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;

    @OneToMany(mappedBy = "store", cascade = {CascadeType.ALL})
    private Set<StoreProduct> storeProducts = new LinkedHashSet<>();

    public void addStoreProduct(StoreProduct storeProduct) {
        storeProduct.setStore(this);
        this.storeProducts.add(storeProduct);
    }
}
