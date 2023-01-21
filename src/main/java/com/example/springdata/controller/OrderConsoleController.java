package com.example.springdata.controller;

import com.example.springdata.dto.OrderDto;
import com.example.springdata.services.OrderService;
import java.util.Scanner;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 17.01.2023
 * 17:16
 */
@Data
@Service
@Slf4j

public class OrderConsoleController {

  private final OrderService orderService;

  /**
   * This method with main logic for this work. Switcher with step by step confirmation.
   */
  public void start() {
    log.info("App start working.");

    while (true) {
      var command = getScanner("""
          Enter command of action:
          0 - create new Order
          1 - get Order By ID
          2 - get All list of Orders
          3 - remove Order by ID from Repository
          4 - remove All Orders from Repository
          9 - finish work with App
          -->\s""");
      switch (Integer.parseInt(command)) {
        case 0 -> createNewOrder();
        case 1 -> {
          int id = Integer.parseInt(getScanner("Enter ID of an Order => "));
          log.info(orderService.getOrderById(id).toString());
        }
        case 2 -> orderService.getAllOrders().forEach(orderDto -> log.info(orderDto.toString()));
        case 3 -> {
          int id = Integer.parseInt(getScanner("Enter ID of an Order => "));
          if (orderService.removeOrderById(id)) {
            log.info("{} {} {}", "Order with ID:", id, "is removed!");
            break;
          }
          log.info("{} {}", "There is no Order with ID:", id);
        }
        case 4 -> {
          if (orderService.removeAllOrders()) {
            log.info("All orders - removed!");
            break;
          }
          log.info("Repository - is already Empty!");
        }
        case 9 -> {
          return;
        }
        default -> System.out.println("wrong command!!!");
      }
    }
  }

  /**
   * This method creates new instance of Order with adding Products to it, one by one.
   */
  private void createNewOrder() {
    var orderDto = new OrderDto();
    orderDto = orderService.createOrder(orderDto);
    while (true) {
      var productName = getScanner(
          "Add Name of Product, you'd like to add to Order => ");
      var productCost = getScanner(
          "Add Cost of Product (in money value 0.0) => ");
      orderDto = orderService.addProduct(orderDto.getId(), productName,
          Double.parseDouble(productCost));
      var scanner = getScanner("Would you like to add another product (Y/N)? => ");
      if (!scanner.equalsIgnoreCase("Y")) {
        break;
      }
    }
  }

  private static String getScanner(String string) {
    var textIn = new Scanner(System.in);
    log.info(string);
    return textIn.next();
  }
}
