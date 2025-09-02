package com.example.events.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record CreateOrderRequest(
    @NotBlank String orderId,
    @NotBlank String customerId,
    @NotNull BigDecimal amount
) {}
