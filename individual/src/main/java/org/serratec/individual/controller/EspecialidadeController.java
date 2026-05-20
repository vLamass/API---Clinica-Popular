package org.serratec.individual.controller;

import java.net.URI;
import java.util.List;

import org.serratec.individual.dto.request.EspecialidadesDTORequest;
import org.serratec.individual.dto.response.EspecialidadesDTOResponse;
import org.serratec.individual.service.EspecialidadeService;
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
@RequestMapping("/especialidades")
@Tag(name = "Especialidades", description = "Endpoints relacionados às especialidades médicas")
public class EspecialidadeController {

    @Autowired EspecialidadeService service;

    @GetMapping
    @Operation(summary = "Listar todas as especialidades")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Especialidades listadas com sucesso"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<List<EspecialidadesDTOResponse>> findAll(){
        List<EspecialidadesDTOResponse> especialidades = service.findAll();
            return ResponseEntity.ok(especialidades);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar especialidade por ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Especialidade encontrada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Especialidade não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<EspecialidadesDTOResponse> findById(@PathVariable Long id){
        EspecialidadesDTOResponse especialidade = service.findById(id);
            return ResponseEntity.ok(especialidade);
    }

    @PostMapping
    @Operation(summary = "Cadastrar nova especialidade")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "Especialidade criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<EspecialidadesDTOResponse> inserir( @Valid @RequestBody EspecialidadesDTORequest dto){
        EspecialidadesDTOResponse criado = service.inserir(dto);

            URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(criado.getId())
				.toUri();
                
            return ResponseEntity.status(HttpStatus.CREATED).body(criado);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar especialidade")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Especialidade atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Especialidade não encontrada"),
        @ApiResponse(responseCode = "400", description = "Requisição inválida"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<EspecialidadesDTOResponse> atualizar( @PathVariable Long id, @Valid @RequestBody EspecialidadesDTORequest dto){
        EspecialidadesDTOResponse atualizado = service.atualizar(id, dto);
            return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar especialidade")
     @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Especialidade removida com sucesso"),
        @ApiResponse(responseCode = "404", description = "Especialidade não encontrada"),
        @ApiResponse(responseCode = "500", description = "Erro interno do servidor")
    })
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        service.deletar(id);
            return ResponseEntity.noContent().build();
    }
}
