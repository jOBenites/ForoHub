package com.alura.forohub.controller.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TopicoRequest(
        @NotBlank(message = "El título es requerido")
        String titulo,
        @NotBlank(message = "El mensaje es requerido")
        String mensaje,
        @NotNull(message = "El autor es requerido")
        Long autorId,
        @NotNull(message = "El curso es requerido")
        Long cursoId
){}
