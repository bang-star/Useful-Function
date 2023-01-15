package com.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@NamedEntityGraph(name = "StoreWithProducts", attributeNodes = {@NamedAttributeNode("store"), @NamedAttributeNode("product")})
public class StoreProduct {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne @JoinColumn(name = "store_id") Store store;

    @ManyToOne @JoinColumn(name = "product_id") Product product;

    private StoreProduct(Store store, Product product) {
        this.store = store;
        this.product = product;
    }

    protected StoreProduct() {}

    public static StoreProduct of(Store store, Product product) {
       return new StoreProduct(store, product);
    }
}
