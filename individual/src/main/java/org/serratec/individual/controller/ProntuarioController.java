package org.serratec.individual.controller;

import java.util.List;

import org.serratec.individual.dto.request.ProntuarioDTORequest;
import org.serratec.individual.dto.response.ProntuarioDTOResponse;
import org.serratec.individual.service.ProntuarioService;
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
@RequestMapping("/prontuarios")
public class ProntuarioController {

    @Autowired
    private ProntuarioService service;

    @GetMapping
    public List<ProntuarioDTOResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ProntuarioDTOResponse findById(@PathVariable Long id) {
        return service.findByid(id);
    }

    @PostMapping
    public ProntuarioDTOResponse inserir(@RequestBody Long id, ProntuarioDTORequest dto) {
        return service.inserir(id,dto);
    }

    @PutMapping("/{id}")
    public ProntuarioDTOResponse atualizar(@PathVariable Long id,
                                          @RequestBody ProntuarioDTORequest dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}