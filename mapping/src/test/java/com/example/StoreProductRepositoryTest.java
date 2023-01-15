package com.example;

import com.example.entity.Image;
import com.example.entity.Product;
import com.example.entity.Store;
import com.example.entity.StoreProduct;
import com.example.repo.ImageRepository;
import com.example.repo.ProductRepository;
import com.example.repo.StoreProductRepository;
import com.example.repo.StoreRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
public class StoreProductRepositoryTest {

    @Autowired StoreRepository storeRepository;
    @Autowired ProductRepository productRepository;
    @Autowired StoreProductRepository storeProductRepository;
    @Autowired ImageRepository imageRepository;

    @Test
    void Select() {
        Store store1 = new Store();
        store1.setName("스타벅스 신림점");
        storeRepository.save(store1);

        Store store2 = new Store();
        store2.setName("스타벅스 서울대점");
        storeRepository.save(store2);

        Product product1 = new Product();
        product1.setName("아메리카노");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("카페라뗴");
        productRepository.save(product2);

        StoreProduct storeProduct1 = storeProductRepository.save(StoreProduct.of(store1, product1));
        StoreProduct storeProduct2 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store1.addStoreProduct(storeProduct1);
        product1.addStoreProduct(storeProduct1);
        store1.addStoreProduct(storeProduct2);
        product2.addStoreProduct(storeProduct2);

        StoreProduct storeProduct3 = storeProductRepository.save(StoreProduct.of(store1, product2));
        StoreProduct storeProduct4 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store2.addStoreProduct(storeProduct3);
        product1.addStoreProduct(storeProduct3);
        store2.addStoreProduct(storeProduct4);
        product2.addStoreProduct(storeProduct4);

        storeProductRepository.findAll().forEach(System.out::println);
    }

    @Test
    void Delete() {
        Store store1 = new Store();
        store1.setName("스타벅스 신림점");
        storeRepository.save(store1);

        Store store2 = new Store();
        store2.setName("스타벅스 서울대점");
        storeRepository.save(store2);

        Product product1 = new Product();
        product1.setName("아메리카노");
        productRepository.save(product1);

        Product product2 = new Product();
        product2.setName("카페라뗴");
        productRepository.save(product2);

        StoreProduct storeProduct1 = storeProductRepository.save(StoreProduct.of(store1, product1));
        StoreProduct storeProduct2 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store1.addStoreProduct(storeProduct1);
        product1.addStoreProduct(storeProduct1);
        store1.addStoreProduct(storeProduct2);
        product2.addStoreProduct(storeProduct2);

        StoreProduct storeProduct3 = storeProductRepository.save(StoreProduct.of(store1, product2));
        StoreProduct storeProduct4 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store2.addStoreProduct(storeProduct3);
        product1.addStoreProduct(storeProduct3);
        store2.addStoreProduct(storeProduct4);
        product2.addStoreProduct(storeProduct4);

        storeProductRepository.findAll().forEach(System.out::println);

        store1.clearStoreProduct();
        storeRepository.delete(store1);
        storeProductRepository.findAll().forEach(System.out::println);
    }

    @Test
    void InsertImage() {
        Store store1 = new Store();
        store1.setName("스타벅스 신림점");
        storeRepository.save(store1);

        Store store2 = new Store();
        store2.setName("스타벅스 서울대점");
        storeRepository.save(store2);

        Product product1 = new Product();
        product1.setName("아메리카노");
        productRepository.save(product1);

        Image image1 = new Image();
        image1.setTitle("아메리카노 1");
        image1.setProduct(product1);
        imageRepository.save(image1);
        product1.addImage(image1);

        Image image2 = new Image();
        image2.setTitle("아메리카노 2");
        image2.setProduct(product1);
        imageRepository.save(image2);
        product1.addImage(image2);

        Product product2 = new Product();
        product2.setName("카페라떼");
        productRepository.save(product2);

        Image image3 = new Image();
        image3.setTitle("카페라떼 1");
        image3.setProduct(product2);
        imageRepository.save(image3);
        product2.addImage(image3);

        Image image4 = new Image();
        image4.setTitle("카페라떼 2");
        image4.setProduct(product2);
        imageRepository.save(image4);
        product2.addImage(image4);

        StoreProduct storeProduct1 = storeProductRepository.save(StoreProduct.of(store1, product1));
        StoreProduct storeProduct2 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store1.addStoreProduct(storeProduct1);
        product1.addStoreProduct(storeProduct1);
        store1.addStoreProduct(storeProduct2);
        product2.addStoreProduct(storeProduct2);

        StoreProduct storeProduct3 = storeProductRepository.save(StoreProduct.of(store1, product2));
        StoreProduct storeProduct4 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store2.addStoreProduct(storeProduct3);
        product1.addStoreProduct(storeProduct3);
        store2.addStoreProduct(storeProduct4);
        product2.addStoreProduct(storeProduct4);

        storeProductRepository.findAll().forEach(System.out::println);
    }

    @Test
    void DeleteImage() {
        Store store1 = new Store();
        store1.setName("스타벅스 신림점");
        storeRepository.save(store1);

        Store store2 = new Store();
        store2.setName("스타벅스 서울대점");
        storeRepository.save(store2);

        Product product1 = new Product();
        product1.setName("아메리카노");
        productRepository.save(product1);

        Image image1 = new Image();
        image1.setTitle("아메리카노 1");
        image1.setProduct(product1);
        imageRepository.save(image1);
        product1.addImage(image1);

        Image image2 = new Image();
        image2.setTitle("아메리카노 2");
        image2.setProduct(product1);
        imageRepository.save(image2);
        product1.addImage(image2);

        Product product2 = new Product();
        product2.setName("카페라떼");
        productRepository.save(product2);

        Image image3 = new Image();
        image3.setTitle("카페라떼 1");
        image3.setProduct(product2);
        imageRepository.save(image3);
        product2.addImage(image3);

        Image image4 = new Image();
        image4.setTitle("카페라떼 2");
        image4.setProduct(product2);
        imageRepository.save(image4);
        product2.addImage(image4);

        StoreProduct storeProduct1 = storeProductRepository.save(StoreProduct.of(store1, product1));
        StoreProduct storeProduct2 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store1.addStoreProduct(storeProduct1);
        product1.addStoreProduct(storeProduct1);
        store1.addStoreProduct(storeProduct2);
        product2.addStoreProduct(storeProduct2);

        StoreProduct storeProduct3 = storeProductRepository.save(StoreProduct.of(store1, product2));
        StoreProduct storeProduct4 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store2.addStoreProduct(storeProduct3);
        product1.addStoreProduct(storeProduct3);
        store2.addStoreProduct(storeProduct4);
        product2.addStoreProduct(storeProduct4);

        product1.clearImages();
        imageRepository.delete(image1);

        storeProductRepository.findAll().forEach(System.out::println);
    }

    @Test
    void DeleteProductWithImages() {
        Store store1 = new Store();
        store1.setName("스타벅스 신림점");
        storeRepository.save(store1);

        Store store2 = new Store();
        store2.setName("스타벅스 서울대점");
        storeRepository.save(store2);

        Product product1 = new Product();
        product1.setName("아메리카노");
        productRepository.save(product1);

        Image image1 = new Image();
        image1.setTitle("아메리카노 1");
        image1.setProduct(product1);
        imageRepository.save(image1);
        product1.addImage(image1);

        Image image2 = new Image();
        image2.setTitle("아메리카노 2");
        image2.setProduct(product1);
        imageRepository.save(image2);
        product1.addImage(image2);

        Product product2 = new Product();
        product2.setName("카페라떼");
        productRepository.save(product2);

        Image image3 = new Image();
        image3.setTitle("카페라떼 1");
        image3.setProduct(product2);
        imageRepository.save(image3);
        product2.addImage(image3);

        Image image4 = new Image();
        image4.setTitle("카페라떼 2");
        image4.setProduct(product2);
        imageRepository.save(image4);
        product2.addImage(image4);

        StoreProduct storeProduct1 = storeProductRepository.save(StoreProduct.of(store1, product1));
        StoreProduct storeProduct2 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store1.addStoreProduct(storeProduct1);
        product1.addStoreProduct(storeProduct1);
        store1.addStoreProduct(storeProduct2);
        product2.addStoreProduct(storeProduct2);

        StoreProduct storeProduct3 = storeProductRepository.save(StoreProduct.of(store1, product2));
        StoreProduct storeProduct4 = storeProductRepository.save(StoreProduct.of(store1, product2));
        store2.addStoreProduct(storeProduct3);
        product1.addStoreProduct(storeProduct3);
        store2.addStoreProduct(storeProduct4);
        product2.addStoreProduct(storeProduct4);

        storeProductRepository.findAll().forEach(System.out::println);

        List<StoreProduct> storeProducts = storeProductRepository.findAllByProduct(product1);
        product1.clearImages();
        store1.removeStoreProducts(storeProducts);
        store2.removeStoreProducts(storeProducts);
        productRepository.delete(product1);

        storeProductRepository.findAll().forEach(System.out::println);
    }
}
