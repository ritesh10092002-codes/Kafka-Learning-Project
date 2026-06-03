package com.example.Order_Service.controller;

import com.example.Order_Service.dto.OrderEvent;
import com.example.Order_Service.service.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer orderProducer;

    @PostMapping
    public String createOrder(@RequestBody OrderEvent orderEvent){
        orderProducer.publish(orderEvent);
        return "Order created";
    }
}
