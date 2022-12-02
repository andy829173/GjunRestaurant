package com.example.gjunrestaurant.dao;

import com.example.gjunrestaurant.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderDao extends CrudRepository<Order, Integer> {
}
