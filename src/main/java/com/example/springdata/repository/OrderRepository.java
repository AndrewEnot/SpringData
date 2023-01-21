package com.example.springdata.repository;

import com.example.springdata.model.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/*
 * @author Oksiuta Andrii
 * 13.01.2023
 * 11:19
 */
@Repository
public interface OrderRepository extends CrudRepository<Order,Integer> {
}
