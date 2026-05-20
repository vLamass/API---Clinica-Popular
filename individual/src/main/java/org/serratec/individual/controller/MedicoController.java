package org.serratec.individual.controller;

import java.util.List;

import org.serratec.individual.dto.request.MedicoDTORequest;
import org.serratec.individual.dto.response.MedicoDTOResponse;
import org.serratec.individual.service.MedicoService;
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
@RequestMapping
public class MedicoController {

    @Autowired MedicoService service;

    @GetMapping
    public ResponseEntity<List<MedicoDTOResponse>> findAll(){
        List<MedicoDTOResponse> medicos = service.findAll();
            return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MedicoDTOResponse> findById(@PathVariable Long id){
        MedicoDTOResponse medico = service.findByID(id);
            return ResponseEntity.ok(medico);
    }

    @PostMapping
    public ResponseEntity<MedicoDTOResponse> inserir(@Valid @RequestBody MedicoDTORequest dto){
        MedicoDTOResponse criado = service.inserir(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MedicoDTOResponse> atualizar(@Valid @PathVariable Long id, @RequestBody MedicoDTORequest dto){
        MedicoDTOResponse atualizado = service.atualizar(id, dto);
            return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
            return ResponseEntity.noContent().build();
    }
}
