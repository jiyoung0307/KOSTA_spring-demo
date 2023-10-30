package com.example.demo.repository;

import com.example.demo.model.Product;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemoryProductRespositoryTest {
  ProductRepository productRepository = new MemoryProductRespository();

  @BeforeEach
  void setUp() {
  }

  @Test
  void findAll() {
    List<Product> allProduct = productRepository.findAll();
//    System.out.println("전체 건수는 : " + allProduct.size());
    Assertions.assertThat(allProduct.size()).isEqualTo(1);
  }

  @Test
  void findById() {
    Product product = productRepository.findById(1);
//    System.out.println("한 건의 제품명은 : " + product.getProductName());
    Assertions.assertThat(product.getProductName()).isEqualTo("제품명1");
  }

  @Test
  void 제품추가테스트() {
    Product product = Product.builder()
        .productName("테스트2")
        .maker("테스트메이커")
        .price(1000)
        .qty(12000)
        .build();
    Product insertProduct = productRepository.insert(product);
    Assertions.assertThat(insertProduct.getProductId()).isEqualTo(2);
  }
}