package com.example.demo;

import com.example.demo.service.AmountOrderService;
import com.example.demo.service.OrderService;
import com.example.demo.service.RateOrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
  //  OrderService를 반환해주는 메소드를 만듦
//  작업지시서를 내가 만드는 방식
//  구현체는 가만히 있고 밑에를 갈아끼는 설정 모음(스프링의 도움X)
  @Bean
  public OrderService orderService() {
//    return new AmountOrderService();  // 14900
    return new RateOrderService();      // 13500
  }
}
