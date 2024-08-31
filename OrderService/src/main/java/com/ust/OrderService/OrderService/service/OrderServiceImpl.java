package com.ust.OrderService.OrderService.service;

import com.ust.OrderService.OrderService.dto.OrderDto;
import com.ust.OrderService.OrderService.model.Order;
import com.ust.OrderService.OrderService.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepo orderRepo;

    @Override
    public Order placeOrder(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public OrderDto checkStatus(long id) {
        Order order = orderRepo.findById(id).orElseThrow(()->new RuntimeException("Order doesnot Exist"));
        OrderDto dto = new OrderDto(order.getOrderId(),order.getItems(),order.getOrderStatus());
        return dto;
    }
}
