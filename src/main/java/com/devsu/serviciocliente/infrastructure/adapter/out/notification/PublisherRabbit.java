/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.devsu.serviciocliente.infrastructure.adapter.out.notification;

import com.devsu.serviciocliente.application.port.out.notification.MessageBrokerPort;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @author rizzoli
 */
@Component
@EnableRabbit
public class PublisherRabbit implements MessageBrokerPort {


    private RabbitTemplate rabbitTemplate;

    public PublisherRabbit(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void send(Object message) {
        rabbitTemplate.convertAndSend("my_queue_cliente", message);
    }
}
