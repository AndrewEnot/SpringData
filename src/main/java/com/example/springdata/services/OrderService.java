package com.example.springdata.services;

import com.example.springdata.dto.OrderDto;
import com.example.springdata.model.Order;
import com.example.springdata.model.Product;
import com.example.springdata.repository.OrderRepository;
import com.example.springdata.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import java.time.LocalDate;
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
  private final ProductRepository productRepository;
  private final ObjectMapper objectMapper;

  public OrderDto createOrder(OrderDto orderDto) {
    if (orderDto == null) {
      log.info("INPUTTED DATA with null!!! ");
      return new OrderDto();
    }
    orderDto.setDateTime(LocalDate.now());
    var order = objectMapper.convertValue(orderDto, Order.class);
    orderRepository.save(order);
    orderDto.setId(order.getId());
    return orderDto;
  }

  public OrderDto addProduct(int orderId, String name, double cost) {
    var order = orderRepository.findById(orderId)
        .orElseThrow(() -> new EntityNotFoundException("NoOrder with such ID!"));
    var product = new Product(null, name, cost, order);
    productRepository.save(product);
    order.setCostTotal(order.getCostTotal() + cost);
    orderRepository.save(order);
    return objectMapper.convertValue(order, OrderDto.class);
  }

  public OrderDto getOrderById(int id) {
    var byId = orderRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No order with such ID!"));
    return objectMapper.convertValue(byId, OrderDto.class);
  }

  public boolean removeOrderById(int id) {
    var byId = orderRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No order with such ID!"));
    orderRepository.delete(byId);
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
    var all = (List<Order>) orderRepository.findAll();
    return all.stream().map(order -> objectMapper.convertValue(order, OrderDto.class)).toList();
  }
}
