package com.example.rabbitmqproductor.services;

import com.example.rabbitmqproductor.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductorService {

    private final RabbitTemplate rabbitTemplate;

    public void enviarMensaje(String mensaje) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.NOME_COLA, mensaje);
        System.out.println("Enviado a RabbitMQ: " + mensaje);
    }
}
