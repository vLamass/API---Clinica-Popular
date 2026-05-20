package org.serratec.individual.controller;

import java.util.List;

import org.serratec.individual.dto.request.PacienteDTORequest;
import org.serratec.individual.dto.response.PacienteDTOResponse;
import org.serratec.individual.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/pacientes")
@Tag(name = "Pacientes", description = "Endpoints relacionados aos pacientes")
public class PacienteController {

    @Autowired PacienteService service;

    @GetMapping
    @Operation(summary = "Listar todos os pacientes")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pacientes listados com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<PacienteDTOResponse>> findAll(){
        List<PacienteDTOResponse> pacientes = service.findAll();
            return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar paciente por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Paciente encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<PacienteDTOResponse> findById(@PathVariable Long id){
        PacienteDTOResponse paciente = service.findByID(id);
            return ResponseEntity.ok(paciente);
    }

    @PostMapping
    @Operation(summary = "Cadastrar paciente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Paciente criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<PacienteDTOResponse> inserir(@Valid @RequestBody PacienteDTORequest dto){
        PacienteDTOResponse criado = service.inserir(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar paciente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Paciente atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<PacienteDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody PacienteDTORequest dto){
        PacienteDTOResponse atualizado = service.atualizar(id, dto);
            return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar paciente")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Paciente removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Paciente não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
            return ResponseEntity.noContent().build();

    }
}
