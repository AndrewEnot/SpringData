package com.example.springdata.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/*
 * @author Oksiuta Andrii
 * 11.01.2023
 * 10:40
 */

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
  @Id
  @GeneratedValue(generator = "sequence-generator")
  @GenericGenerator(
      name = "sequence-generator",
      strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
      parameters =  {
          @Parameter(name = "sequence_name", value = "my_order.my_product_id_seq")
      }
  )
  private Integer id;
  private String name;
  private double cost;
}
