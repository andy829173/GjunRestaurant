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
        try {
            Order order = findById(id);
            order.setPaid(true);
            return orderDao.save(order);
        } catch (Exception e) {
            return null;
        }
    }

    public String deleteOrder(Integer id) {
        Order order = findById(id);
        orderDao.delete(order);
        return order + " is deleted!";
    }

    public Order updatePrice(Integer id, Integer totalPrice) {
        Order order = findById(id);
        order.setTotalPrice(totalPrice);
        return orderDao.save(order);
    }

    public Order findById(Integer id) {
        Order order = orderDao.findById(id).get();
        return order;
    }
}
