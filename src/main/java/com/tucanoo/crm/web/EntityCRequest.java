package com.tucanoo.crm.web;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record EntityCRequest(
        @NotBlank String category,
        @NotBlank String description,
        @Min(0) @Max(100) int priorityScore) {
}
