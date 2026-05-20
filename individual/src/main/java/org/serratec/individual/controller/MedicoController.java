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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/medicos")
@Tag(name = "Médicos", description = "Endpoints relacionados aos médicos")
public class MedicoController {

    @Autowired MedicoService service;

    @GetMapping
    @Operation(summary = "Listar todos os médicos")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Médicos listados com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<MedicoDTOResponse>> findAll(){
        List<MedicoDTOResponse> medicos = service.findAll();
            return ResponseEntity.ok(medicos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar médico por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Médico encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Médico não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<MedicoDTOResponse> findById(@PathVariable Long id){
        MedicoDTOResponse medico = service.findByID(id);
            return ResponseEntity.ok(medico);
    }

    @PostMapping
    @Operation(summary = "Cadastrar médico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Médico criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<MedicoDTOResponse> inserir(@Valid @RequestBody MedicoDTORequest dto){
        MedicoDTOResponse criado = service.inserir(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar médico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Médico atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Médico não encontrado"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<MedicoDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody MedicoDTORequest dto){
        MedicoDTOResponse atualizado = service.atualizar(id, dto);
            return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar médico")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Médico removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Médico não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
            return ResponseEntity.noContent().build();
    }
}
