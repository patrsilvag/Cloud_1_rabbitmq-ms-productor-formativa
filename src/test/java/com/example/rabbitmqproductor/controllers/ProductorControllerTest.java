package com.example.rabbitmqproductor.controllers;

import com.example.rabbitmqproductor.controllers.ProductorController;
import com.example.rabbitmqproductor.services.ProductorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductorController.class)
class ProductorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductorService productorService;

    @Test
    void testPublicarMensajeEndpoint() throws Exception {
        String mensaje = "Mensaje de prueba";

        mockMvc.perform(
                post("/api/productor/enviar").contentType(MediaType.TEXT_PLAIN).content(mensaje))
                .andExpect(status().isOk());
    }
}
