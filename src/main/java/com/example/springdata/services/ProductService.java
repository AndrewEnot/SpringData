package com.example.springdata.services;

import com.example.springdata.dto.ProductDto;
import com.example.springdata.model.Product;
import com.example.springdata.repository.ProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

  public ProductDto createProduct(ProductDto productDto) {
    Product product = objectMapper.convertValue(productDto, Product.class);
    productRepository.save(product);
    productDto.setId(product.getId());
    return productDto;
  }

  public ProductDto getById(int id) {
    return objectMapper.convertValue(productRepository.findById(id), ProductDto.class);
  }

  public ProductDto getByName(String name) {
    return objectMapper.convertValue(productRepository.getByName(name), ProductDto.class);
  }

  public List<ProductDto> getAllProducts() {
    List<Product> productDtoList = (List<Product>) productRepository.findAll();
    return productDtoList.stream()
        .map(product -> objectMapper.convertValue(product, ProductDto.class)).toList();
  }
}