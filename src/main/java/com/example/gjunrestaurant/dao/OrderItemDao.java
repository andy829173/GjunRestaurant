package com.example.gjunrestaurant.dao;

import com.example.gjunrestaurant.entity.OrderItem;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemDao extends CrudRepository<OrderItem, Integer> {

    // 自定義SQL查詢
    @Query(value = "SELECT * FROM order_item WHERE orderid = ?1", nativeQuery = true)
    List<OrderItem> queryByOrderID(String orderID);

    @Query(value = "DELETE FROM order_item WHERE productid = ?1", nativeQuery = true)
    OrderItem deleteByProductID(Integer productID);
}
