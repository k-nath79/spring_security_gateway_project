package com.ust.OrderService.SwiggyApp.service;


import com.ust.OrderService.SwiggyApp.dto.OrderResponseDto;
import com.ust.OrderService.SwiggyApp.feignclient.SwiggyOrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SwiggyService {
    @Autowired
    SwiggyOrderFeign swiggyOrderFeign;

    public OrderResponseDto getOrderById(long Id){
        return swiggyOrderFeign.getOrderById(Id);
    }
}
