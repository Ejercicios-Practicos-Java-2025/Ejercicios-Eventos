# Spring Cloud Stream - Producer

Simple REST → Kafka producer using Spring Cloud Stream + Kafka binder.

## How to run

1) Boot Kafka locally:

```bash
docker compose up -d
```

(From the repo root where `docker-compose.yml` lives.)

2) Start the app:

```bash
./mvnw spring-boot:run
```

3) Send a test message:

```bash
curl -X POST http://localhost:8081/api/orders -H "Content-Type: application/json" -d '{"customerId":"C-123","amount": "150.50"}'
```

Messages are sent to topic `orders.topic`.
