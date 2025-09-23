# Spring Cloud Stream - Consumer

Consumes `OrderEvent` messages from `orders.topic` using the functional consumer `orders`.

## How to run

1) Boot Kafka (if not already running):

```bash
docker compose up -d
```

2) Start the app:

```bash
./mvnw spring-boot:run
```

You should see logs for each `OrderEvent` produced by the producer service.
