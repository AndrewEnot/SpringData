package com.example.springdata.configuration;

import com.example.springdata.dto.OrderDto;
import com.example.springdata.dto.ProductDto;
import com.example.springdata.services.OrderService;
import com.example.springdata.services.ProductService;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 12.01.2023
 * 11:11
 */

@Configuration
@Data

public class OrderConfiguration {

  private final ProductService productService;

  private final OrderService orderService;

  @Autowired
  public OrderConfiguration(ProductService productService, OrderService orderService) {
    this.productService = productService;
    this.orderService = orderService;
  }

  @Bean
  public OrderDto orderOne() {
    List<ProductDto> ordersList = getProductList("fanta", "cola", "sprite");
    return orderService.createOrder(new OrderDto(ordersList));
  }

  @Bean
  public OrderDto orderTwo() {
    List<ProductDto> ordersList = getProductList("fanta", "sprite", "fanta", "sprite");
    return orderService.createOrder(new OrderDto(ordersList));
  }

  @Bean
  public OrderDto orderThree() {
    List<ProductDto> ordersList = getProductList("cola", "fanta", "cola", "sprite");
    return orderService.createOrder(new OrderDto(ordersList));
  }

  @Bean
  public OrderDto orderFour() {
    List<ProductDto> ordersList = getProductList("cola", "cola", "sprite", "cola");
    return orderService.createOrder(new OrderDto(ordersList));
  }

  private List<ProductDto> getProductList(String... products) {
    List<ProductDto> ordersList = new ArrayList<>();
    for (String product : products) {
      ordersList.add(productService.getByName(product));
    }
    return ordersList;
  }
}
