package com.aluracursos.forohub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosActualizarTopico(
        @NotBlank
        Long id,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso
) {
}