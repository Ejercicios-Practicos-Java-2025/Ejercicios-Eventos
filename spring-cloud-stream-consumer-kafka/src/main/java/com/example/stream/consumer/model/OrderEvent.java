package com.example.stream.consumer.model;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderEvent(
        String id,
        String customerId,
        BigDecimal amount,
        Instant createdAt
) { }
