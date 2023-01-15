package com.example.repo;

import com.example.entity.Product;
import com.example.entity.Store;
import com.example.entity.StoreProduct;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreProductRepository extends JpaRepository<StoreProduct, Integer> {

    @EntityGraph("StoreWithProducts")
    List<StoreProduct> findAll();

    void deleteAllByStore(Store store);

    @EntityGraph("StoreWithProducts")
    List<StoreProduct> findAllByProduct(Product product);
}
