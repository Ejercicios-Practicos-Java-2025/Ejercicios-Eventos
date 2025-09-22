package com.example.consumer.messaging;

import com.example.consumer.domain.OrderCreatedEvent;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventConsumer {

  @KafkaListener(topics = "orders.created.v1", groupId = "orders-consumer",
                 containerFactory = "kafkaListenerContainerFactory")
  public void onOrderCreated(ConsumerRecord<String, OrderCreatedEvent> record) {
    var event = record.value();
    System.out.printf("✅ Consumido orderId=%s amount=%s%n",
        event.orderId(), event.amount());
  }
}
