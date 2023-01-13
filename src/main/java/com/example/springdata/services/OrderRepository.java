package com.example.springdata.services;

import com.example.springdata.model.Order;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 11.01.2023
 * 10:43
 */
@Service
@Getter
@Setter
public class OrderRepository {

  private final Map<Integer, Order> orders;

  @Autowired
  public OrderRepository(List<Order> list) {
    this.orders = list.stream().collect(Collectors.toMap(Order::getId, a -> a));
  }

  public void addOrder(Order order) {
    if (order != null) {
      orders.put(order.getId(), order);
    }
  }

  public Order getOrderById(int id) {
    return orders.get(id);
  }

  public List<Order> getAllOrders() {
    return orders.values().stream().toList();
  }
}
