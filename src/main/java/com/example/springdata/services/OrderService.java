package com.example.springdata.services;

import com.example.springdata.dto.OrderDto;
import com.example.springdata.model.Order;
import com.example.springdata.repository.OrderRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 17.01.2023
 * 14:18
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

  private final OrderRepository orderRepository;
  private final ObjectMapper objectMapper;

  public OrderDto createOrder(OrderDto orderDto) {
    if (orderDto == null) {
      log.info("INPUTTED DATA with null!!! ");
      return new OrderDto();
    }
    Order order = objectMapper.convertValue(orderDto, Order.class);
    orderRepository.save(order);
    orderDto.setId(order.getId());
    return orderDto;
  }

  public OrderDto getOrderById(int id) {
    return objectMapper.convertValue(orderRepository.findById(id), OrderDto.class);
  }

  public boolean removeOrderById(int id) {
    Order orderById = orderRepository.findById(id).orElse(new Order());
    orderRepository.delete(orderById);
    return true;
  }

  public boolean removeAllOrders() {
    if (orderRepository != null) {
      orderRepository.deleteAll();
      return true;
    }
    return false;
  }

  public List<OrderDto> getAllOrders() {
    List<Order> all = (List<Order>)orderRepository.findAll();
    return all.stream().map(order -> objectMapper.convertValue(order, OrderDto.class)).toList();
  }
}
