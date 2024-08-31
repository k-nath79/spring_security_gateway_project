package com.ust.OrderService.SwiggyApp.controller;

import com.ust.OrderService.SwiggyApp.dto.OrderResponseDto;
import com.ust.OrderService.SwiggyApp.service.SwiggyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/swiggy")
public class SwiggyController {

    @Autowired
    SwiggyService swiggyService;

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> checkOrderStatus(@PathVariable long id){
        OrderResponseDto dto = swiggyService.getOrderById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(dto);
    }

    @GetMapping("/hello")
    public String printhello(){
        return "Hello";
    }

}
