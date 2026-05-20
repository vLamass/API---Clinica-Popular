package org.serratec.individual.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.individual.dto.request.ConsultaDTORequest;
import org.serratec.individual.dto.response.ConsultaDTOResponse;
import org.serratec.individual.entity.Consulta;
import org.serratec.individual.entity.Medico;
import org.serratec.individual.entity.Paciente;
import org.serratec.individual.exception.NotFoundException;
import org.serratec.individual.repository.ConsultaRepository;
import org.serratec.individual.repository.MedicoRepository;
import org.serratec.individual.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private MedicoRepository medicoRepository;

    public List<ConsultaDTOResponse> findAll(){

        List<Consulta> consultas = consultaRepository.findAll();

        List<ConsultaDTOResponse> consultasDTO = new ArrayList<>();

        for(Consulta consulta:consultas){
            consultasDTO.add(new ConsultaDTOResponse(consulta));
        }
            return consultasDTO;
    }

    public ConsultaDTOResponse findById(Long id){

        Consulta consulta = consultaRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Consulta não encontrada"));
                
        return new ConsultaDTOResponse(consulta);
    }

    @Transactional
    public ConsultaDTOResponse inserir(ConsultaDTORequest dto){

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(()-> new NotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
            .orElseThrow(()-> new NotFoundException("Medico não encontrado"));
            
        Consulta consulta = new Consulta();
        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setHoraConsulta(dto.getHoraConsulta());
        consulta.setObservacao(dto.getObservacao());
        consulta.setStatus(dto.getStatus());
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        
        consulta = consultaRepository.save(consulta);

        return new ConsultaDTOResponse(consulta);

    }

    @Transactional
    public ConsultaDTOResponse atualizar (Long id, ConsultaDTORequest dto){
        
        Consulta consulta = consultaRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Consulta não encontrada"));

        Paciente paciente = pacienteRepository.findById(dto.getPacienteId())
            .orElseThrow(()-> new NotFoundException("Paciente não encontrado"));

        Medico medico = medicoRepository.findById(dto.getMedicoId())
            .orElseThrow(()-> new NotFoundException("Medico não encontrado"));

        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setHoraConsulta(dto.getHoraConsulta());
        consulta.setObservacao(dto.getObservacao());
        consulta.setStatus(dto.getStatus());
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        consulta = consultaRepository.save(consulta);

        return new ConsultaDTOResponse(consulta);
    }

    @Transactional
    public void deletar (Long id){

        Consulta consulta = consultaRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Consulta não encontrada"));

        consultaRepository.delete(consulta);
    }

}
