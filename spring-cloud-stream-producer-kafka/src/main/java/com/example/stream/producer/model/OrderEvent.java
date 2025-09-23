package com.example.stream.producer.model;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderEvent(
        String id,
        String customerId,
        BigDecimal amount,
        Instant createdAt
) { }
