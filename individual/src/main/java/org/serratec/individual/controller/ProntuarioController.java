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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/prontuarios")
@Tag(name = "Prontuários", description = "Endpoints relacionados aos prontuários médicos")
public class ProntuarioController {

    @Autowired
    private ProntuarioService service;

    @GetMapping
    @Operation(summary = "Listar todos os prontuários")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Prontuários listados com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<ProntuarioDTOResponse>> findAll() {
        List <ProntuarioDTOResponse> prontuarios = service.findAll();
            return ResponseEntity.ok(prontuarios);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar prontuário por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Prontuário encontrado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Prontuário não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<ProntuarioDTOResponse> findById(@PathVariable Long id) {
        ProntuarioDTOResponse prontuario = service.findByid(id);
            return ResponseEntity.ok(prontuario);
    }

    @PostMapping
    @Operation(summary = "Criar prontuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Prontuário criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<ProntuarioDTOResponse> inserir(@Valid @RequestBody ProntuarioDTORequest dto) {
        ProntuarioDTOResponse criado = service.inserir(dto);
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar prontuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Prontuário atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Prontuário não encontrado"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<ProntuarioDTOResponse> atualizar(@PathVariable Long id, @Valid @RequestBody ProntuarioDTORequest dto) {
        ProntuarioDTOResponse atualizado = service.atualizar(id, dto);
            return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar prontuário")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Prontuário removido com sucesso"),
        @ApiResponse(responseCode = "404", description = "Prontuário não encontrado"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
            return ResponseEntity.noContent().build();
    }
}