package com.example.springdata;

import com.example.springdata.controller.OrderConsoleController;
import com.example.springdata.dto.OrderDto;
import com.example.springdata.dto.ProductDto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class SpringDataApplication {

  private final OrderConsoleController orderConsoleController;


  @Autowired
  public SpringDataApplication(OrderConsoleController orderConsoleController) {
    this.orderConsoleController = orderConsoleController;
  }


  public static void main(String[] args) {
    SpringApplication.run(SpringDataApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onInit() {

    orderConsoleController.getProductService().createProduct(new ProductDto("Cola", 49.90));
    orderConsoleController.getProductService().createProduct(new ProductDto("Fanta", 49.80));
    orderConsoleController.getProductService().createProduct(new ProductDto("Pepsi", 49.70));

    List<ProductDto> ordersList = getProductList("fanta", "cola", "sprite");
    orderConsoleController.getOrderService().createOrder(new OrderDto(ordersList));
    List<ProductDto> ordersList1 = getProductList("fanta", "sprite", "fanta", "sprite");
    orderConsoleController.getOrderService().createOrder(new OrderDto(ordersList1));
    List<ProductDto> ordersList2 = getProductList("cola", "fanta", "cola", "sprite");
    orderConsoleController.getOrderService().createOrder(new OrderDto(ordersList2));
    List<ProductDto> ordersList3 = getProductList("cola", "cola", "sprite", "cola");
    orderConsoleController.getOrderService().createOrder(new OrderDto(ordersList3));

    orderConsoleController.start();
  }

  private List<ProductDto> getProductList(String... products) {
    List<ProductDto> ordersList = new ArrayList<>();
    for (String product : products) {
      ordersList.add(orderConsoleController.getProductService().getByName(product));
    }
    return ordersList;
  }
}
