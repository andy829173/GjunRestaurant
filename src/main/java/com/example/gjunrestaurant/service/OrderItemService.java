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

    public List<OrderItem> readOrderItemList(Integer orderID) {
        List<OrderItem> orderItemList = orderItemDao.queryByOrderID(orderID);
        return orderItemList;
    }

    public String updateOrderItem(Integer orderID, List<OrderItem> orderItemList) {
        List<OrderItem> pastOrderItemList = readOrderItemList(orderID);
        String msg = null;
        for (int i = 0; i <= pastOrderItemList.size(); i++) {
            Integer quantity = orderItemList.get(i).getQuantity();
            Integer newProductID = orderItemList.get(i).getProductID();
            Integer pastProductID = pastOrderItemList.get(i).getProductID();

            // 數量為0則刪除
            if (quantity == 0) {
                msg += orderItemDao.deleteByProductID(pastProductID);
                // 數量小於0則錯誤
            } else if (quantity < 0) {
                msg += "ProductID: " + newProductID + " Failed! The quantity cannot less than 0.\n";
            } else {
                // 若 productID 相符則修改數量
                if (pastProductID == newProductID) {
                    pastOrderItemList.get(i).setQuantity(orderItemList.get(i).getQuantity());
                    orderItemDao.save(pastOrderItemList.get(i));
                    msg += "ProductID: " + pastProductID + " has be updated.\n";
                    // 若productID 不相符則新增品項
                } else {
                    OrderItem newItem = new OrderItem();
                    newItem.setOrderID(orderID);
                    newItem.setProductID(newProductID);
                    newItem.setQuantity(orderItemList.get(i).getQuantity());
                    OrderItemService orderItemService = new OrderItemService();
                    orderItemService.createOrderItem(newItem);
                    msg += "ProductID: " + newProductID + " has be created!\n";
                }
            }
        }
        return msg;
    }

    // 刪除全部OrderItem(by orderID)
    public String deleteOrderItemList(Integer orderID) {
        List<OrderItem> orderItemList = orderItemDao.queryByOrderID(orderID);
        for (OrderItem orderItem : orderItemList) {
            orderItemDao.delete(orderItem);
        }
        return "Order Detail has be deleted!!";
    }

    // 刪除一筆OrderItem
    public String deleteOrderItem(Integer productID) {
        OrderItem orderItem = orderItemDao.deleteByProductID(productID);
        return "ProductID: " + productID + " has be deleted!\n";
    }
}
