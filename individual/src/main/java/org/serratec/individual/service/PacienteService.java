package org.serratec.individual.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.individual.dto.request.PacienteDTORequest;
import org.serratec.individual.dto.response.PacienteDTOResponse;
import org.serratec.individual.entity.Paciente;
import org.serratec.individual.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class PacienteService {

    @Autowired PacienteRepository pacienteRepository;


    public List<PacienteDTOResponse> findAll(){

        List<Paciente> pacientes = pacienteRepository.findAll();

        List<PacienteDTOResponse> pacientesDTO = new ArrayList<>();

        for(Paciente paciente:pacientes ){
            pacientesDTO.add(new PacienteDTOResponse(paciente));
        }
        return pacientesDTO;
    }

    public PacienteDTOResponse findByID(Long id){

        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Paciente não Encontrado"));

        return new PacienteDTOResponse(paciente);    
    }


    @Transactional
    public PacienteDTOResponse inserir (PacienteDTORequest dto){

        if(pacienteRepository.existsByCpf(dto.getCpf())){
            throw new RuntimeException("CPF já cadastrado");
        }

        if(pacienteRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("Email já cadastrado");
        }

        Paciente paciente = new Paciente();
        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setEmail(dto.getEmail());
        paciente.setDataNascimento(dto.getDataNascimento());

        paciente = pacienteRepository.save(paciente);

        return new PacienteDTOResponse(paciente);

    }

    @Transactional
    public PacienteDTOResponse atualizar (Long id, PacienteDTORequest dto){

        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Paciente não Encontrado"));

        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setEmail(dto.getEmail());
        paciente.setDataNascimento(dto.getDataNascimento());

        paciente = pacienteRepository.save(paciente);

        return new PacienteDTOResponse(paciente);

    }

    @Transactional
    public void deletar (Long id){
        
        Paciente paciente = pacienteRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Paciente não Encontrado"));

        pacienteRepository.delete(paciente);    
    }



}
