package com.example.events.messaging;

import com.example.events.domain.OrderCreatedEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {

  private final KafkaTemplate<String, Object> kafkaTemplate;

  public OrderEventProducer(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public void publishOrderCreated(OrderCreatedEvent event) {
    kafkaTemplate.send("orders.created.v1", event.orderId(), event);
  }
}
