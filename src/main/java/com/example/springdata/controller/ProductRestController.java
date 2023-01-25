package com.example.springdata.controller;

import com.example.springdata.dto.ProductDto;
import com.example.springdata.services.ProductService;
import java.util.List;
import lombok.RequiredArgsConstructor;
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
@RequestMapping("/api/example")
public class ProductRestController {

  private final ProductService productService;

  @GetMapping(value = "/products/{id}")
  public ProductDto getProductById(@PathVariable int id) {
    return productService.getById(id);
  }

  @GetMapping(value = "/products")
  public List<ProductDto> getAllProducts() {
    return productService.getAllProducts();
  }
}
