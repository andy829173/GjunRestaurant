package com.example.gjunrestaurant.dao;

import com.example.gjunrestaurant.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderDao extends CrudRepository<Order, Integer> {

    // 自定義SQL查詢
    @Query(value = "SELECT * FROM order", nativeQuery = true)
    List<Order> queryFindAll();

    @Query(value = "DELETE FROM order WHERE id = ?1", nativeQuery = true)
    Order queryDeleteByOrderID(String orderID);

    @Query(value = "SELECT * FROM order WHERE id = ?1", nativeQuery = true)
    Order queryFindByOrderID(String orderID);
}
