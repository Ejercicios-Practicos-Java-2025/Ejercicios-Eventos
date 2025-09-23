package com.example.stream.producer.api;

import com.example.stream.producer.model.OrderEvent;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Map;
import java.util.UUID;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.function.StreamBridge;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
	
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	
    private final StreamBridge streamBridge;

    @Value("${app.bindings.orders-out:orders-out}")
    private String bindingName;

    public OrderController(StreamBridge streamBridge) {
        this.streamBridge = streamBridge;
    }

    @PostMapping
    public Map<String, Object> create(@RequestBody @Validated Map<String, Object> payload) {
        String id = UUID.randomUUID().toString();
        String customerId = String.valueOf(payload.getOrDefault("customerId", "CUST-001"));
        BigDecimal amount = new BigDecimal(String.valueOf(payload.getOrDefault("amount", "99.99")));

        OrderEvent event = new OrderEvent(id, customerId, amount, Instant.now());
        Message<OrderEvent> msg = MessageBuilder.withPayload(event)
                .setHeader("type", "OrderCreated")
                .build();

        boolean sent = streamBridge.send(bindingName, msg);
        
        logger.info("✅ Producer OrderEvent: id={}, customer={}, amount={}, createdAt={}",
                event.id(), event.customerId(), event.amount(), event.createdAt());
        
        return Map.of("sent", sent, "id", id, "binding", bindingName);
    }
}
