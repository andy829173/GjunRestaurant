package com.example.gjunrestaurant.dao;

import com.example.gjunrestaurant.entity.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemDao extends CrudRepository<OrderItem, Integer> {

    // 自定義SQL查詢
    @Query(value = "select * from order_item where orderid = ?1", nativeQuery = true)
    List<OrderItem> queryByOrderID(Integer orderID);
}
