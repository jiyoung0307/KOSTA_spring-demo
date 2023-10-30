package com.example.demo.service;

import org.springframework.stereotype.Service;

// @Service
public class RateOrderService implements OrderService {
  private final int DISCOUNT_RATE = 10;

  @Override
  public int getPrice(int price) {
    return price - (price / DISCOUNT_RATE);  // 10000 - (10000/10) = 9000
  }
}
