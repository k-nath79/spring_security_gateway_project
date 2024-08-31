package com.ust.OrderService.SwiggyApp.dto;

import java.util.List;

public record OrderResponseDto( long OrderId,
                                List<String>items,
                                String OrderStatus) {

}
