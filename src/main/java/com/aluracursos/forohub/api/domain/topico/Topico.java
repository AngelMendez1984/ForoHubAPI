package com.aluracursos.forohub.api.domain.topico;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name="Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@Setter

public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String autor;
    private String curso;
    private LocalDateTime fechaCreacion;

    public Topico(DatosRegistoTopico datosRegistoTopico) {
        this.id=getId();
        this.titulo=datosRegistoTopico.titulo();
        this.mensaje=datosRegistoTopico.mensaje();
        this.autor=datosRegistoTopico.autor();
        this.curso=datosRegistoTopico.curso();
        this.fechaCreacion=LocalDateTime.now();
    }
    public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
        this.titulo = datosActualizarTopico.titulo();
        this.mensaje = datosActualizarTopico.mensaje();
        this.autor = datosActualizarTopico.autor();
        this.curso = datosActualizarTopico.curso();
    }
}
