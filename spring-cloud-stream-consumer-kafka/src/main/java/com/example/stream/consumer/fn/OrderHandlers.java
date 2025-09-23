package com.example.stream.consumer.fn;

import com.example.stream.consumer.model.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class OrderHandlers {
    private static final Logger log = LoggerFactory.getLogger(OrderHandlers.class);

    @Bean
    public Consumer<OrderEvent> orders() {
        return event -> log.info("✅ Consumer(Received) OrderEvent: id={}, customer={}, amount={}, createdAt={}",
                event.id(), event.customerId(), event.amount(), event.createdAt());
    }
}
