package com.example.springdata.controller;

import com.example.springdata.dto.OrderDto;
import com.example.springdata.dto.ProductDto;
import com.example.springdata.services.OrderService;
import com.example.springdata.services.ProductService;
import java.util.ArrayList;
import java.util.List;
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
  private final ProductService productService;

  public void start() {
    log.info("App start working.");

    while (true) {
      String command = getScanner("""
          Enter command of action:
          0 - create new Order
          1 - get Order By ID
          2 - get All list of Orders
          3 - remove Order by ID from Repository
          4 - remove All Orders from Repository
          5 - get All list of Products
          6 - add new Product
          9 - finish work with App
          -->\s""");
      switch (Integer.parseInt(command)) {
        case 0 -> createProductConsole();
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
        case 5 ->
            productService.getAllProducts().forEach(productDto -> log.info(productDto.toString()));
        case 6 -> {
          String name = getScanner("Add Name of Product => ");
          String cost = getScanner("Add Cost of Product => ");
          ProductDto productDto = new ProductDto(name, Double.parseDouble(cost));
          productService.createProduct(productDto);
        }
        case 9 -> {
          return;
        }
        default -> System.out.println("wrong command!!!");
      }
    }
  }

  private void createProductConsole() {
    String ids = getScanner(
        "Add Names of Products (using ','), you'd like to add to Order => ");
    String[] productArray = ids.toLowerCase().replace(" ", "").split(",");
    List<ProductDto> productList = new ArrayList<>();
    for (String s : productArray) {
      for (ProductDto productDto : productService.getAllProducts()) {
        if (productDto.getName().equals(s)) {
          productList.add(productService.getByName(s));
          OrderDto orderDto = new OrderDto(productList);
          orderService.createOrder(orderDto);
        } else {
          log.info("{} {}", "There is no product in repository with name", s);
        }
      }
    }
  }

  private static String getScanner(String string) {
    Scanner textIn = new Scanner(System.in);
    log.info(string);
    return textIn.next();
  }
}
