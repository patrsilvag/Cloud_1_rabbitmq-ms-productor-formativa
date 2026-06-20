# Microservicio Productor - RabbitMQ (Actividad Formativa 5)

Microservicio encargado de exponer un endpoint REST para la recepción de mensajes, los cuales son publicados en un broker RabbitMQ para su procesamiento asíncrono.

## Arquitectura
El servicio actúa como el nodo de entrada del sistema:
- **Spring Boot Web**: Para exponer el endpoint de recepción (`/api/productor/enviar`).
- **Spring Boot AMQP**: Para la serialización y envío de mensajes al Exchange.

## Tecnologías
* **Java 21**
* **Spring Boot 3.5.14**
* **RabbitMQ**
* **Lombok**
* **JUnit 5 / Mockito / MockMvc** (Pruebas unitarias e integración)

## Configuración
El archivo `application.properties` debe apuntar a tu broker RabbitMQ:

```properties
# RabbitMQ
spring.rabbitmq.host=localhost
spring.rabbitmq.port=5672
spring.rabbitmq.username=guest
spring.rabbitmq.password=guest