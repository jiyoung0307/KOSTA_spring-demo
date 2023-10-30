package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
//ctrl + shift + T => test 생성
public class MemoryProductRespository implements ProductRepository {
  private static Map<Integer, Product> productMap = new HashMap<>();
  private static int seq = 0;

  public MemoryProductRespository() {
    seq++;
    Product product
        = Product.builder()
        .productId(seq)
        .productName("제품명1")
        .maker("오리")
        .price(15000)
        .qty(100)
        .build();

    productMap.put(seq, product);
  }

  @Override
  public List<Product> findAll() {
    return new ArrayList<>(productMap.values());
  }

  @Override
  public Product findById(int productId) {
    return productMap.get(productId);
  }

  @Override
  public Product insert(Product product) {
    productMap.put(++seq, product);
    product.setProductId(seq);  // 이 부분이 없으면 seq 번호가 0번이 되므로 1이 증가하지 않는다. 주의하자
    return product;
  }
}