package com.aluracursos.forohub.api.domain.topico;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistoTopico (
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotBlank
        String autor,
        @NotBlank
        String curso
){
}
