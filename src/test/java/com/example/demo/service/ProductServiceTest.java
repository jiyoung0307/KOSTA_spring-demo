package com.example.demo.service;

import com.example.demo.repository.MemoryProductRespository;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class ProductServieTest {
//  ProductService에서 Autowired로 간접적으로 주입해주었음
//  그러므로 직접 주입해주어야 함
  ProductRepository productRepository = new MemoryProductRespository();
  ProductService productServie = new ProductService(productRepository);
  @Test
  void getAllProducts() {
  }
}