package com.example.events.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.Instant;

public record OrderCreatedEvent(
    @NotBlank String eventId,
    @NotBlank String orderId,
    @NotBlank String customerId,
    @NotNull BigDecimal amount,
    Instant createdAt
) {}
