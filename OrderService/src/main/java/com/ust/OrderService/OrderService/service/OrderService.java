package com.ust.OrderService.OrderService.service;

import com.ust.OrderService.OrderService.dto.OrderDto;
import com.ust.OrderService.OrderService.model.Order;

public interface OrderService {
    Order placeOrder(Order order);
    OrderDto checkStatus(long id);
}
