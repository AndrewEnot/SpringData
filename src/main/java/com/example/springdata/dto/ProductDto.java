package com.example.springdata.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
 * @author Oksiuta Andrii
 * 13.01.2023
 * 11:28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
  private Integer id;
  private String name;
  private double cost;

  public ProductDto(String name, double cost){
    this.name = name;
    this.cost = cost;
  }
}
