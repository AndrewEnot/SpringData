package com.example.springdata.services;

import com.example.springdata.dto.ProductDto;
import com.example.springdata.model.Product;
import com.example.springdata.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.EntityNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 17.01.2023
 * 14:18
 */
@Service
@RequiredArgsConstructor
public class ProductService {

  private final ProductRepository productRepository;
  private final ObjectMapper objectMapper;

  public ProductDto getById(int id) {
    var byId = productRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("No product with such ID!"));
    return objectMapper.convertValue(byId, ProductDto.class);
  }

  public List<ProductDto> getAllProducts() {
    var productList = (List<Product>) productRepository.findAll();
    return productList.stream()
        .map(product -> objectMapper.convertValue(product, ProductDto.class)).toList();
  }
}