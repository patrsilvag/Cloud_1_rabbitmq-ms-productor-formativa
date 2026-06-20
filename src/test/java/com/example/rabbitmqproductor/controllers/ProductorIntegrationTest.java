package com.example.rabbitmqproductor.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.test.context.SpringRabbitTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest // Carga todo el contexto de Spring
@AutoConfigureMockMvc // Configura MockMvc automáticamente
@SpringRabbitTest // Habilita el entorno de RabbitMQ para pruebas
class ProductorIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testFlujoIntegracionCompleto() throws Exception {
        String mensaje = "Mensaje de integración real";

        // Simula la llamada REST y verifica que el flujo llega hasta la capa de infraestructura
        mockMvc.perform(
                post("/api/productor/enviar").contentType(MediaType.TEXT_PLAIN).content(mensaje))
                .andExpect(status().isOk());
    }
}
