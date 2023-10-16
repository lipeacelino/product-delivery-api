package com.example.productdeliveryapi.rabbitmq.publisher;

import com.example.productdeliveryapi.entities.Product;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ProductCreatedPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${rabbitmq.product.created.exchange}")
    private String exchange;

    @Value("${rabbitmq.product.created.routing.key}")
    private String routingKey;

    public void send(Product product) {
        rabbitTemplate.convertAndSend(exchange, routingKey, product);
    }
}
