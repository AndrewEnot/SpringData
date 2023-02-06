package com.example.springdata.controller;

import com.example.springdata.dto.OrderDto;
import com.example.springdata.services.OrderService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * @author Oksiuta Andrii
 * 12.01.2023
 * 11:58
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("orders")
public class OrderRestController {

  private final OrderService orderService;

  @GetMapping(value = "{id}")
  public OrderDto getById(@PathVariable int id) {
    return orderService.getOrderById(id);
  }

  @GetMapping
  public List<OrderDto> getAllOrders() {
    return orderService.getAllOrders();
  }
}
