package com.example.springdata.configuration;

import com.example.springdata.dto.ProductDto;
import com.example.springdata.services.ProductService;
import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @author Oksiuta Andrii
 * 10.01.2023
 * 14:27
 */
@Configuration
@Data
public class ProductConfiguration {

  private final ProductService productService;

  @Bean
  public ProductDto productDtoCola() {
    return productService.createProduct(new ProductDto("Cola", 49.90));
  }
  @Bean
  public ProductDto productDtoFanta() {
    return productService.createProduct(new ProductDto("Fanta", 49.80));
  }
  @Bean
  public ProductDto productDtoPepsi() {
    return productService.createProduct(new ProductDto("Pepsi", 49.70));
  }
}
