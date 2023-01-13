package com.example.springdata.configuration;

import com.example.springdata.model.Order;
import com.example.springdata.model.Product;
import com.example.springdata.services.ProductRepository;
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
@Service
@Data

public class OrderConfiguration {

  private final ProductRepository repository;

  @Autowired
  public OrderConfiguration(ProductRepository repository) {
    this.repository = repository;
  }

  @Bean
  public Order orderOne() {
    List<Product> ordersList = getProductList(4455, 3322, 6699, 4455);
    return new Order(1, ordersList);
  }

  @Bean
  public Order orderTwo() {
    List<Product> ordersList = getProductList(4455, 3322, 4455, 3322);
    return new Order(2, ordersList);
  }

  @Bean
  public Order orderThree() {
    List<Product> ordersList = getProductList(4455, 3322, 6699, 6699);
    return new Order(3, ordersList);
  }

  @Bean
  public Order orderFour() {
    List<Product> ordersList = getProductList(4455, 3322, 6699, 3322);
    return new Order(4, ordersList);
  }

  private List<Product> getProductList(int... products) {
    List<Product> ordersList = new ArrayList<>();
    for (int i : products) {
      ordersList.add(repository.getById(i));
    }
    return ordersList;
  }
}
