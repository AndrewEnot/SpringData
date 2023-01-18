package com.example.springdata.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * @author Oksiuta Andrii
 * 11.01.2023
 * 10:38
 */

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "order")
public class Order {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @JsonSerialize(using = LocalDateSerializer.class)
  @JsonDeserialize(using = LocalDateDeserializer.class)
  private LocalDateTime dateTime;
  private double costTotal;
  @ManyToMany(cascade = { CascadeType.ALL })
  @JoinTable(
      name = "order_product",
      joinColumns = { @JoinColumn(name = "fk_order_id") },
      inverseJoinColumns = { @JoinColumn(name = "fk_product_id") }
  )
  private List<Product> products;

  public Order(List<Product> products) {
    this.dateTime = LocalDateTime.now();
    this.products = products;
    double costs = 0.0;
    for (Product product : products) {
      costs += product.getCost();
    }
    this.costTotal = (Math.round(costs * 100)) / 100.0;
  }
}
