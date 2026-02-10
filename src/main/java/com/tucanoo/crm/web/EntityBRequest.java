package com.tucanoo.crm.web;

import java.math.BigDecimal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public record EntityBRequest(
        @NotBlank String title,
        @NotNull @PositiveOrZero BigDecimal amount,
        boolean active) {
}
