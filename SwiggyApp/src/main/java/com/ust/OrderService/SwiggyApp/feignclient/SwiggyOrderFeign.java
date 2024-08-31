package com.ust.OrderService.SwiggyApp.feignclient;

import com.ust.OrderService.SwiggyApp.dto.OrderResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ORDERSERVICE")
public interface SwiggyOrderFeign {
    @GetMapping("/order/{id}")
    OrderResponseDto getOrderById(@PathVariable long id);
}
