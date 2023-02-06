package com.example.springdata.servlet;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    log.info("CustomListener is initialized");
  }

  @Override
  public void contextDestroyed(ServletContextEvent sce) {
    log.info("CustomListener is destroyed");
  }
}
