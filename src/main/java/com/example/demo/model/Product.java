package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

@Data
// 테스트할때 필요
@Builder
public class Product {
  private int productId;
  private String productName;
  private String maker;
  private int price;
  private int qty;    // 수량
}
