package com.example.rabbitmqproductor.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    // El nombre debe coincidir exactamente con el del consumidor
    public static final String NOME_COLA = "micola";

    @Bean
    public Queue miCola() {
        return new Queue(NOME_COLA, true);
    }
}
