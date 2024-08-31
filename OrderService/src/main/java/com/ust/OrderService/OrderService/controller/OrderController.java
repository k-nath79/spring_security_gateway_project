package com.ust.OrderService.OrderService.controller;

import com.ust.OrderService.OrderService.dto.OrderDto;
import com.ust.OrderService.OrderService.model.Order;
import com.ust.OrderService.OrderService.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/placeorder")
    public Order placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }

    @GetMapping("/{id}")
    public OrderDto getOrder(@PathVariable long id){
        return orderService.checkStatus(id);
    }
}
