package com.example.springdata.configuration;

import com.example.springdata.servlet.CustomListener;
import com.example.springdata.servlet.CustomServlet;
import jakarta.servlet.ServletContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @author Oksiuta Andrii
 * 06.02.2023
 * 9:34
 */
@Configuration
public class ServletConfiguration {

  @Bean
  public ServletRegistrationBean customServletBean() {
    ServletRegistrationBean bean = new ServletRegistrationBean(new CustomServlet(),
        "/my-servlet");
    return bean;
  }


  @Bean
  public ServletListenerRegistrationBean<ServletContextListener> customListenerBean() {
    ServletListenerRegistrationBean<ServletContextListener> bean =
        new ServletListenerRegistrationBean();
    bean.setListener(new CustomListener());
    return bean;
  }

}
