package com.aluracursos.forohub.api.controller;

import com.aluracursos.forohub.api.domain.topico.DatosActualizarTopico;
import com.aluracursos.forohub.api.domain.topico.DatosRegistoTopico;
import com.aluracursos.forohub.api.domain.topico.Topico;
import com.aluracursos.forohub.api.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;
    @PostMapping
    public ResponseEntity<Topico> registrarTopico(@RequestBody @Valid DatosRegistoTopico datosRegistoTopico, UriComponentsBuilder uriBuilder) {
        Topico nuevoTopico = new Topico(datosRegistoTopico);
        topicoRepository.save(nuevoTopico);

        URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(nuevoTopico.getId()).toUri();
        return ResponseEntity.created(uri).body(nuevoTopico);
    }

    @GetMapping
    public ResponseEntity<List<Topico>> listadoTopicos() {
        List<Topico> topicos = topicoRepository.findAll();
        return ResponseEntity.ok(topicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> detalleTopico(@PathVariable Long id) {
        Optional<Topico> optionalTopico = topicoRepository.findById(id);
        if (optionalTopico.isPresent()) {
            return ResponseEntity.ok(optionalTopico.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Topico> actualizarTopico(@RequestBody DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarTopico(datosActualizarTopico);
        return ResponseEntity.ok(topico);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();


    }
}
