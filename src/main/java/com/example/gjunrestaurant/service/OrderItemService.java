package com.example.gjunrestaurant.service;

import com.example.gjunrestaurant.dao.OrderItemDao;
import com.example.gjunrestaurant.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemService {
    @Autowired
    OrderItemDao orderItemDao;

    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemDao.save(orderItem);
    }

    public List<OrderItem> readOrderItem(Integer orderID) {
        List<OrderItem> orderItemList = orderItemDao.queryByOrderID(orderID);
        return orderItemList;
    }

    public String updateOrderItem(Integer orderID, List<OrderItem> orderItemList) {
        List<OrderItem> pastOrderItemList = readOrderItem(orderID);
        String msg = null;
        for (int i = 0; i <= pastOrderItemList.size(); i++) {

            // 若修改 productID 不相符跳過
            if (pastOrderItemList.get(i).getProductID() != orderItemList.get(i).getProductID()) {
                continue;
            }
            // 若修改 productID 相符
            if (pastOrderItemList.get(i).getProductID() == orderItemList.get(i).getProductID()) {
                Integer quantity = orderItemList.get(i).getQuantity();
                if (quantity < 0) {
                    msg = "Failed! The quantity cannot less than 0.";
                } else if (quantity == 0) {
                    orderItemDao.delete(pastOrderItemList.get(i));
                    msg = pastOrderItemList.get(i) + " has be Deleted!!";
                } else {
                    pastOrderItemList.get(i).setQuantity(orderItemList.get(i).getQuantity());
                    orderItemDao.save(pastOrderItemList.get(i));
                    msg = pastOrderItemList.get(i) + "has been updated.";
                }
            }
        }
        return msg;
    }

    public String deleteOrderItem(Integer orderID) {
        List<OrderItem> orderItemList = orderItemDao.queryByOrderID(orderID);
        for (OrderItem orderItem : orderItemList) {
            orderItemDao.delete(orderItem);
        }
        return "Order Detail has been deleted!!";
    }
}
