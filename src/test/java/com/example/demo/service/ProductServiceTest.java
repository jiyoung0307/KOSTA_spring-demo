package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.repository.MemoryProductRespository;
import com.example.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class ProductServieTest {
//  ProductService에서 Autowired로 간접적으로 주입해주었음
//  그러므로 직접 주입해주어야 함
  ProductRepository productRepository = new MemoryProductRespository();
  ProductService productService = new ProductService(productRepository);
  @Test
  void addProduct() {
    Product product =
        Product.builder()
            .productName("test1")
            .maker("test")
            .price(15000)
            .qty(100)
            .build();
    String s = productService.addProduct(product);
    assertThat(s).isEqualTo("새로운 제품 추가 성공");
    //assertThat(productServie.getAllProducts().size()).isEqualTo(2);
  }


}