package org.yasmani.io.exampleusermicro.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(
        @NotBlank @Size(max = 100) String nombre,
        @NotBlank @Email @Size(max = 320) String email,
        @Size(max = 50) String documento
) {}
