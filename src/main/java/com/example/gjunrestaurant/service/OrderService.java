package com.example.gjunrestaurant.service;

import com.example.gjunrestaurant.dao.OrderDao;
import com.example.gjunrestaurant.dao.OrderItemDao;
import com.example.gjunrestaurant.dao.ProductDao;
import com.example.gjunrestaurant.entity.Order;
import com.example.gjunrestaurant.entity.OrderItem;
import com.example.gjunrestaurant.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderItemDao orderItemDao;
    @Autowired
    OrderDao orderDao;
    @Autowired
    ProductDao productDao;

    public List<Order> getOrders() {
        List<Order> orderList = orderDao.queryFindAll();
        return orderList;
    }

    public List<OrderItem> readOrderItemList(String orderID) {
        List<OrderItem> orderItemList = orderItemDao.queryByOrderID(orderID);
        return orderItemList;
    }

    // 新增訂單明細
    public OrderItem createOrderItem(OrderItem orderItem) {
        return orderItemDao.save(orderItem);
    }

    // 新增整筆訂單
    public String createOrder(List<OrderItem> orderItemList) {
        Order newOrder = new Order();
        String orderID = newOrder.getID();
        Integer totalPrice = 0;
        for (OrderItem orderItem : orderItemList) {
            Integer productID = orderItem.getProductID();
            Product product = productDao.findById(productID).get();
            Integer priceEach = product.getProductPrice();
            Integer quantity = orderItem.getQuantity();
            totalPrice += priceEach * quantity;

            orderItem.setOrderID(orderID);
            orderItem.setProductID(productID);
            orderItem.setQuantity(quantity);
            orderItem.setPrice(priceEach);
            orderItemDao.save(orderItem);
        }
        newOrder.setTotalPrice(totalPrice);
        orderDao.save(newOrder);
        return newOrder.getID() + "has been created";
    }

    public String updateOrderItem(String orderID, List<OrderItem> orderItemList) {
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
                    pastOrderItemList.get(i).setQuantity(quantity);
                    orderItemDao.save(pastOrderItemList.get(i));
                    msg += "ProductID: " + pastProductID + " has been updated.\n";
                    // 若productID 不相符則新增品項
                } else {
                    OrderItem newItem = new OrderItem();
                    newItem.setOrderID(orderID);
                    newItem.setProductID(newProductID);
                    newItem.setQuantity(quantity);
                    OrderService orderItemService = new OrderService();
                    orderItemService.createOrderItem(newItem);
                    msg += "ProductID: " + newProductID + " has been created!\n";
                }
            }
        }
        return msg;
    }

    // 刪除整筆Order
    public String deleteOrder(String orderID) {
        List<OrderItem> orderItemList = orderItemDao.queryByOrderID(orderID);
        for (OrderItem orderItem : orderItemList) {
            orderItemDao.delete(orderItem);
        }
        orderDao.queryDeleteByOrderID(orderID);
        return "OrderID: " + orderID + " has been deleted!!";
    }

    // 刪除單筆OrderItem
    public String deleteOrderItem(Integer productID) {
        OrderItem orderItem = orderItemDao.deleteByProductID(productID);
        return "ProductID: " + productID + " has been deleted!";
    }

    public String toPay(String orderID) {
        Order dbOrder = orderDao.queryFindByOrderID(orderID);
        dbOrder.setPaid(true);
        orderDao.save(dbOrder);
        return "OrderID: " + orderID + " has paid.";
    }
}
