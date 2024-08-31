package com.ust.OrderService.OrderService.dto;

import java.util.List;

public record OrderDto(long OrderId,
        List<String> items,
                       String OrderStatus) {
}
