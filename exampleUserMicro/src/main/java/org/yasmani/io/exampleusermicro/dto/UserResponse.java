package org.yasmani.io.exampleusermicro.dto;

import java.time.Instant;
import java.util.UUID;

public record UserResponse(
        UUID id,
        String nombre,
        String email,
        String documento,
        Instant createdAt,
        Instant updatedAt
) {}
