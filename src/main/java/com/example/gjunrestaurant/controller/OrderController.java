package com.example.gjunrestaurant.controller;

import com.example.gjunrestaurant.dto.order.OrderDto;
import com.example.gjunrestaurant.entity.Order;
import com.example.gjunrestaurant.entity.OrderItem;
import com.example.gjunrestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<String> createOrder(@RequestBody List<OrderDto> orderDtoList) {
        try {
            String msg = orderService.createOrder(orderDtoList);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Something wrong!", HttpStatus.FORBIDDEN);
        }
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
}
