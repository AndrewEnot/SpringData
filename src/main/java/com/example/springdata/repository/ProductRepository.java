package com.example.springdata.repository;

import com.example.springdata.model.Product;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Oksiuta Andrii
 * 13.01.2023
 * 11:19
 */
@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

  Product getByName(String name);
//  Product getById(int id);
//  List<Product> getAllProducts();

}
