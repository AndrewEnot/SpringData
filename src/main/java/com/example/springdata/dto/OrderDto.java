package com.example.springdata.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import java.time.LocalDateTime;
import java.util.List;
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
public class OrderDto {

  private Integer id;
  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDateTime dateTime;
  private double costTotal;
  private List<ProductDto> products;

  public OrderDto(List<ProductDto> products) {
    this.dateTime = LocalDateTime.now();
    this.products = products;
    double costs = 0.0;
    for (ProductDto product : products) {
      costs += product.getCost();
    }
    this.costTotal = (Math.round(costs * 100)) / 100.0;
  }
}
