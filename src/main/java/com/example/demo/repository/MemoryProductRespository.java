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
    product.setProductId(seq);  // 이 부분이 없으면 seq 번호가 0번이 되므로 1이 증가하지 않는다. 주의하자
    productMap.put(++seq, product);
    return product;
  }

  @Override
  public Product update(int productId, Product product) {
    Product updateProduct = productMap.get(productId);
    if (updateProduct != null) {
      updateProduct.setQty(product.getQty());   // 존재하지 않으면 null 리턴하고 update 진행 X
      productMap.put(productId, updateProduct);
    }
    return updateProduct;
  }

  @Override
  public Product delete(int productId) {
    Product removeProduct = productMap.remove(productId);
    return removeProduct;
  }
}