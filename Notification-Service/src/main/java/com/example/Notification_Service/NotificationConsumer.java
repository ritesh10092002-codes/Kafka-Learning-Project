package com.example.Notification_Service;

import com.example.Notification_Service.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(
            topics = "order-topic",
            groupId = "notification-group"
    )
    public void consume(OrderEvent event) {

        System.out.println(
                "================================="
        );

        System.out.println(
                "Notification Sent"
        );

        System.out.println(
                "Order Id : " + event.getOrderId()
        );

        System.out.println(
                "Product : " + event.getProductName()
        );

        System.out.println(
                "Amount : " + event.getProductAmount()
        );

        System.out.println(
                "================================="
        );
    }
}
