package com.example.springdata.services;


import com.example.springdata.model.Product;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 12.01.2023
 * 11:19
 */
@Service
@Data
public class ProductRepository {

  private final Map<Integer, Product> repository;

  @Autowired
  public ProductRepository(List<Product> list) {
    this.repository = list.stream().collect(Collectors.toMap(Product::getId, a -> a));
  }

  public Product getById(int id) {
    if (repository.containsKey(id)) {
      return repository.get(id);
    }
    System.out.println("There is no Product with such Id!!!");
    return null;
  }
}
