package org.serratec.individual.controller;

import java.util.List;

import org.serratec.individual.dto.request.ProntuarioDTORequest;
import org.serratec.individual.dto.response.ProntuarioDTOResponse;
import org.serratec.individual.service.ProntuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService service;

    @GetMapping
    public ResponseEntity<List<ProntuarioDTOResponse>> findAll() {
        List <ProntuarioDTOResponse> prontuarios = service.findAll();
            return ResponseEntity.ok(prontuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProntuarioDTOResponse> findById(@PathVariable Long id) {
        ProntuarioDTOResponse prontuario = service.findByid(id);
            return ResponseEntity.ok(prontuario);
    }

    @PostMapping
    public ResponseEntity<ProntuarioDTOResponse> inserir(@Valid @RequestBody Long id, ProntuarioDTORequest dto) {
        ProntuarioDTOResponse criado = service.inserir(id, dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProntuarioDTOResponse> atualizar(@Valid @PathVariable Long id,@RequestBody ProntuarioDTORequest dto) {
        ProntuarioDTOResponse atualizado = service.atualizar(id, dto);
            return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
            return ResponseEntity.noContent().build();
    }
}