package com.example.demo.repository;

public class AmountOrderRepository implements OrderRepository {
  private final int DISCOUNT_AMOUNT = 100;


  @Override
  public int getPrice(int price) {
    return price - DISCOUNT_AMOUNT;
  }
}
