package com.example.Order_Service.service;

import com.example.Order_Service.dto.OrderEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public void publish(OrderEvent orderEvent){
        kafkaTemplate.send("order-topic",orderEvent);

        System.out.println("Published: "+orderEvent);
    }
}
