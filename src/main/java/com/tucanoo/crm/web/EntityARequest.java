package com.tucanoo.crm.web;

import jakarta.validation.constraints.NotBlank;

public record EntityARequest(
        @NotBlank String displayName,
        @NotBlank String status) {
}
