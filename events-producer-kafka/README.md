# events-producer

Spring Boot Kafka **Producer** split from your original project.

## Run
1. Start Kafka (see `docker-compose` folder).
2. `mvn spring-boot:run`
3. Publish an order:
   ```bash
   curl -X POST http://localhost:8081/api/orders \        -H "Content-Type: application/json" \        -d '{"orderId":"o-1","customerId":"c-1","amount":123.45}'
   ```
