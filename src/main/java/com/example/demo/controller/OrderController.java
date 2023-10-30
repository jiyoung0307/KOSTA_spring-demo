package com.example.demo.controller;

import com.example.demo.AppConfig;
import com.example.demo.model.Product;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products/orders")
public class OrderController {
  //  주입받을 Service
  private final ProductService productService;
  private final OrderService orderService;

//  Annotation을 사용하지 않고 설정파일을 넣어서 실행하는 방법(스프링 도움X)
  public OrderController(ProductService productService,
                         OrderService orderService) {
    this.productService = productService;
    this.orderService = orderService;
//    AppConfig appConfig = new AppConfig();
//    orderService = appConfig.orderService();
  }

  @GetMapping("/{productId}")
//  PathVariable로부터 받아서 바인딩됨
  // AmountOrderService - 14900
  // RateOrderService - 13500
  public int getProductPrice(@PathVariable int productId) {
    Product product = productService.getProduct(productId);
    int price = orderService.getPrice(product.getPrice());
    return price;
  }
}
