package com.example.rabbitmqproductor.services;

import com.example.rabbitmqproductor.config.RabbitMQConfig;
import com.example.rabbitmqproductor.services.ProductorService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductorServiceTest {

    @Mock
    private RabbitTemplate rabbitTemplate;

    @InjectMocks
    private ProductorService productorService;

    @Test
    void testEnviarMensaje() {
        String mensaje = "Hola Rabbit";

        productorService.enviarMensaje(mensaje);

        verify(rabbitTemplate, times(1)).convertAndSend(RabbitMQConfig.NOME_COLA, mensaje);
    }
}
