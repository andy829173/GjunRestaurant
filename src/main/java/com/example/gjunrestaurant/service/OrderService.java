package com.example.gjunrestaurant.service;

import com.example.gjunrestaurant.dao.OrderDao;
import com.example.gjunrestaurant.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    OrderDao orderDao;

    public Iterable<Order> getOrder() {
        return orderDao.findAll();
    }

    public Iterable<Order> createOrder(Order order) {
        orderDao.save(order);
        return getOrder();
    }

    public Order toPay(Integer id) {
        Order dbOrder = findById(id);
        dbOrder.setPaid(true);
        return orderDao.save(dbOrder);
    }

    public String deleteOrder(Integer id) {
        Order dbOrder = findById(id);
        orderDao.delete(dbOrder);
        return dbOrder + " is deleted!";
    }

    public Order updatePrice(Integer id, Integer totalPrice) {
        Order dbOrder = findById(id);
        dbOrder.setTotalPrice(totalPrice);
        return orderDao.save(dbOrder);
    }

    public Order findById(Integer id) {
        Order dbOrder = orderDao.findById(id).get();
        return dbOrder;
    }
}
