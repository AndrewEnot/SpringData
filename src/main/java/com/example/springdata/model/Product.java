package com.example.springdata.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

/*
 * @author Oksiuta Andrii
 * 11.01.2023
 * 10:40
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Id
  int id;
  String name;
  double cost;

}
