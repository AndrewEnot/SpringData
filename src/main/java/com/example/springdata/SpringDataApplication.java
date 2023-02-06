package com.example.springdata;

import com.example.springdata.controller.OrderConsoleController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@RequiredArgsConstructor
public class SpringDataApplication {

  private final OrderConsoleController orderConsoleController;


  public static void main(String[] args) {
    SpringApplication.run(SpringDataApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void onInit() {
    orderConsoleController.start();
  }
}
