package com.example.springdata.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomServlet extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    log.info("CustomServlet doGet() method is invoked");
    resp.setContentType("text/plain");
    resp.setStatus(200);
    resp.getWriter().println("My Result " + LocalDate.now());
    resp.getWriter().close();
  }
}
