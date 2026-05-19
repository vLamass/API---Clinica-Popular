package org.serratec.individual.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.individual.dto.request.ProntuarioDTORequest;
import org.serratec.individual.dto.response.ProntuarioDTOResponse;
import org.serratec.individual.entity.Paciente;
import org.serratec.individual.entity.Prontuario;
import org.serratec.individual.repository.PacienteRepository;
import org.serratec.individual.repository.ProntuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ProntuarioService {

    @Autowired ProntuarioRepository prontuarioRepository;

    @Autowired PacienteRepository pacienteRepository;

    public List<ProntuarioDTOResponse> findAll(){

        List<Prontuario> prontuarios = prontuarioRepository.findAll();

        List<ProntuarioDTOResponse> prontuariosDTO = new ArrayList<>();

        for(Prontuario prontuario:prontuarios){
            prontuariosDTO.add(new ProntuarioDTOResponse(prontuario));
        }
        return prontuariosDTO;
    } 

    public ProntuarioDTOResponse findByid(Long id){
        
        Prontuario prontuario = prontuarioRepository.findById(id)
        .orElseThrow(()-> new RuntimeException("Prontuario não encontrado"));
        
        return new ProntuarioDTOResponse(prontuario);
    }
    
    @Transactional
    public ProntuarioDTOResponse inserir(Long id, ProntuarioDTORequest dto) { 

        Paciente paciente =pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(()-> new RuntimeException("Paciente não encontrado"));

            Prontuario prontuario = new Prontuario();

            prontuario.setHistoricoMedico(dto.getHistoricoMedico());
            prontuario.setAlergias(dto.getAlergias());
            prontuario.setMedicamentosEmUso(dto.getMedicamentoEmUso());
            prontuario.setObservacoesProntuario(dto.getObservacoesProntuario());
            prontuario.setPaciente(paciente);

            prontuario = prontuarioRepository.save(prontuario);

            return new ProntuarioDTOResponse(prontuario);
        }
        

    @Transactional
    public ProntuarioDTOResponse atualizar (Long id, ProntuarioDTORequest dto){

        Prontuario prontuario = prontuarioRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Prontuario não encontrado"));
        
        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(()-> new RuntimeException("Paciente não encontrado"));
            
            
        prontuario.setHistoricoMedico(dto.getHistoricoMedico());
        prontuario.setAlergias(dto.getAlergias());
        prontuario.setMedicamentosEmUso(dto.getMedicamentoEmUso());
        prontuario.setObservacoesProntuario(dto.getObservacoesProntuario());
        prontuario.setPaciente(paciente);
        
        prontuario = prontuarioRepository.save(prontuario);

        return new ProntuarioDTOResponse(prontuario);
    }   


    public void deletar(Long id){

        Prontuario prontuario = prontuarioRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Prontuario não encontrado"));

        prontuarioRepository.delete(prontuario);  
    }

    }




