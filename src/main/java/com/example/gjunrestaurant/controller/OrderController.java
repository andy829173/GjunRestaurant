package com.example.gjunrestaurant.controller;

import com.example.gjunrestaurant.entity.Order;
import com.example.gjunrestaurant.entity.OrderItem;
import com.example.gjunrestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public String createOrder(@RequestBody List<OrderItem> orderItemList) {
        return orderService.createOrder(orderItemList);
    }

    @GetMapping("/order")
    public List<Order> getOrder() {
        return orderService.getOrders();
    }

    @PutMapping("/order")
    public String updateOrder(String orderID, List<OrderItem> orderItemList) {
        return orderService.updateOrderItem(orderID, orderItemList);
    }

    @DeleteMapping("/order")
    public String deleteOrder(String orderID) {
        return orderService.deleteOrder(orderID);
    }

    @PatchMapping("/order/paid")
    public String toPaid(String orderID) {
        String msg;
        try {
            msg = orderService.toPay(orderID);
        } catch (Exception e) {
            msg = "Pay Failed";
        }
        return msg;
    }

    @GetMapping("/test")
    public String justTest(Model model) {
        model.addAttribute("msg", "test");
        return "orderPage";
    }
}
