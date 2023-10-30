package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
// ctrl + shift + T => test 생성
public class MemoryProductRespository implements ProductRepository{
  private static Map<Integer, Product> productMap = new HashMap<>();
  private static int seq = 0;

  public MemoryProductRespository() {
    seq++;
    Product product =
        Product.builder()
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
    product.setProductId(seq);
    Product put = productMap.put(++seq, product);
    return put;
  }

  @Override
  public Product update(int productId, Product product) {
    Product updateProduct = productMap.get(productId);
    if(updateProduct != null) {
      updateProduct.setQty(product.getQty());  // 존재하지 않으면 null 리턴하고 update 진행 X
      productMap.put(productId, updateProduct);
    }
    return updateProduct;
  }

  @Override
  public Product delete(int productId) {
    Product removedProduct = productMap.remove(productId);
    return removedProduct;
  }
}