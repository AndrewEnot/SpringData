package com.example.springdata;

import com.example.springdata.controller.OrderConsoleController;
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
    orderConsoleController.start();
  }
}
