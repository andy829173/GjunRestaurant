package com.example.gjunrestaurant.controller;

import com.example.gjunrestaurant.entity.Order;
import com.example.gjunrestaurant.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public String createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return "Create success";
    }

    @GetMapping("/read")
    public Iterable<Order> getOrder() {
        Iterable<Order> orderList = orderService.getOrder();
        return orderList;
    }

    @PostMapping("/paid")
    public String updateOrder(Integer id) {
        try {
            orderService.toPay(id);
            return "Paid!!";
        } catch (Exception e) {
            return "Failed";
        }
    }

    @PostMapping("/updatePrice")
    public Order updatePrice(Integer id, Integer totalPrice) {
        orderService.updatePrice(id, totalPrice);
        return orderService.findById(id);
    }

    @GetMapping("/test")
    public String insertData() {
        List<Order> data = List.of(new Order("2022/12/8", "18:00", 1380),
                new Order("2022/12/1", "14:00", 980),
                new Order("2022/12/2", "17:30", 1080),
                new Order("2022/12/3", "18:45", 1880),
                new Order("2022/12/4", "19:30", 2160),
                new Order("2022/12/5", "12:30", 4580),
                new Order("2022/12/6", "11:45", 2330),
                new Order("2022/12/7", "11:00", 1170),
                new Order("2022/12/9", "12:00", 1580),
                new Order("2022/12/10", "14:00", 1673),
                new Order("2022/12/11", "17:00", 1490),
                new Order("2022/12/12", "17:45", 2180),
                new Order("2022/12/13", "18:00", 2960)
        );
        try {
            for (Order order : data) {
                orderService.createOrder(order);
            }
            return "Success";
        } catch (Exception e) {
            return "Failed";
        }
    }
}
