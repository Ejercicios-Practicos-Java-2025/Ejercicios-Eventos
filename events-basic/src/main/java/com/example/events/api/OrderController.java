package com.example.events.api;

import com.example.events.domain.OrderCreatedEvent;
import com.example.events.messaging.OrderEventProducer;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

  private final OrderEventProducer producer;

  public OrderController(OrderEventProducer producer) {
    this.producer = producer;
  }

  @PostMapping
  public String createOrder(@Valid @RequestBody CreateOrderRequest req) {
    var event = new OrderCreatedEvent(
        UUID.randomUUID().toString(),
        req.orderId(),
        req.customerId(),
        req.amount(),
        Instant.now()
    );
    producer.publishOrderCreated(event);
    return "Published order event: " + event.orderId();
  }
}
