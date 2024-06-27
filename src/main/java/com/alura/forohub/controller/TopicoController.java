package com.alura.forohub.controller;

import com.alura.forohub.controller.dto.TopicoRequest;
import com.alura.forohub.model.Topico;
import com.alura.forohub.service.TopicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TopicoController {

    @Autowired
    private TopicoService service;

    @GetMapping("/topicos")
    ResponseEntity<List<Topico>> listTopicos(){
        List<Topico> lst = service.readTopico();
        return ResponseEntity.ok(lst);
    }

    @PostMapping("/topicos")
    ResponseEntity<Topico> addTopico(@Valid @RequestBody TopicoRequest request) {
        Topico obj = service.createTopico(request);
        return ResponseEntity.ok(obj);
    }

    @PutMapping("/topicos/{id}")
    ResponseEntity<Topico> updateTopico(@Valid @RequestBody TopicoRequest request, @PathVariable Long id) {
        Topico obj = service.updateTopico(request, id);
        return ResponseEntity.ok(obj);
    }

    @DeleteMapping("/topicos/{id}")
    ResponseEntity<Topico> deleteTopico(@PathVariable Long id) {
        Topico obj = service.deleteTopico(id);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/topicos/{id}")
    ResponseEntity<Topico> getTopico(@PathVariable Long id){
        Topico obj = service.findTopico(id);
        return ResponseEntity.ok(obj);
    }
}
