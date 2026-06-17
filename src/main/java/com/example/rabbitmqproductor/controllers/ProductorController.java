package com.example.rabbitmqproductor.controllers;

import com.example.rabbitmqproductor.services.ProductorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/productor")
@RequiredArgsConstructor
public class ProductorController {

    private final ProductorService productorService;

    @PostMapping("/enviar")
    public ResponseEntity<String> publicarMensaje(@RequestBody String mensaje) {
        productorService.enviarMensaje(mensaje);
        return ResponseEntity.ok("Mensaje enviado exitosamente a la cola");
    }
}
