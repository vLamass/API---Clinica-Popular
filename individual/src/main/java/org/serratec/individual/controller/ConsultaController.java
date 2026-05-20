package org.serratec.individual.controller;

import java.net.URI;
import java.util.List;

import org.serratec.individual.dto.request.ConsultaDTORequest;
import org.serratec.individual.dto.response.ConsultaDTOResponse;
import org.serratec.individual.service.ConsultaService;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
@Tag(name = "Consultas", description = "Endpoints relacionados às consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService service;

    @GetMapping
    @Operation(summary = "Listar todas as consultas")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Consultas listadas com sucesso"),
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<ConsultaDTOResponse>>findAll(){
        List<ConsultaDTOResponse> consultas = service.findAll();
            return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar consulta por ID")
    @ApiResponses(value = {
    @ApiResponse(responseCode = "200", description = "Consulta encontrada"),
    @ApiResponse(responseCode = "404", description = "Consulta não encontrada"),
    @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<ConsultaDTOResponse> findById(@PathVariable Long id){
        ConsultaDTOResponse consulta = service.findById(id);
            return ResponseEntity.ok(consulta);
    }

    @PostMapping
     @Operation(summary = "Cadastrar nova consulta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Consulta criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<ConsultaDTOResponse> inserir(@Valid @RequestBody ConsultaDTORequest dto){
        ConsultaDTOResponse criado = service.inserir(dto);
            
            URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(criado.getId())
				.toUri();
            
                return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar consulta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Consulta atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Consulta não encontrada"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<ConsultaDTOResponse> atualizar( @PathVariable Long id, @Valid @RequestBody ConsultaDTORequest dto){
        ConsultaDTOResponse atualizado = service.atualizar(id, dto);
            return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar consulta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Consulta removida com sucesso"),
        @ApiResponse(responseCode = "404", description = "Consulta não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
            return ResponseEntity.noContent().build();
    }
}
