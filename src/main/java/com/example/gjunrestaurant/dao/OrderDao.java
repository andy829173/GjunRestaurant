package com.example.gjunrestaurant.dao;

import com.example.gjunrestaurant.entity.Order;
import com.example.gjunrestaurant.entity.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDao extends CrudRepository<Order, Integer> {

    // 自定義SQL查詢
    @Query(value = "SELECT * FROM order", nativeQuery = true)
    List<Order> queryFindAll();

    @Query(value = "DELETE FROM order WHERE id = ?1", nativeQuery = true)
    OrderItem deleteByOrderID(String orderID);
}
