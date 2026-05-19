package org.serratec.individual.controller;

import java.util.List;

import org.serratec.individual.dto.request.PacienteDTORequest;
import org.serratec.individual.dto.response.PacienteDTOResponse;
import org.serratec.individual.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired PacienteService service;

    @GetMapping
    public List<PacienteDTOResponse> findAll(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public PacienteDTOResponse findById(@PathVariable Long id){
        return service.findByID(id);
    }

    @PostMapping
    public PacienteDTOResponse inserir(@RequestBody Long id, PacienteDTORequest dto){
        return service.inserir(dto);
    }

    @PutMapping("/{id}")
    public PacienteDTOResponse atualizar(@PathVariable Long id, @RequestBody PacienteDTORequest dto){
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        service.deletar(id);

    }
}
