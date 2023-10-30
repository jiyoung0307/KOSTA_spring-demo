package com.example.demo.repository;

public interface OrderRepository {
  int getPrice(int price);    // 1) 10000 ==> 9900원 return(100원 할인)  2) 10000 ==> 9000원 return(10% 할인)

}
