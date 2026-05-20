package org.serratec.individual.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.individual.dto.request.MedicoDTORequest;
import org.serratec.individual.dto.response.MedicoDTOResponse;
import org.serratec.individual.entity.Especialidade;
import org.serratec.individual.entity.Medico;
import org.serratec.individual.exception.ConflictException;
import org.serratec.individual.exception.NotFoundException;
import org.serratec.individual.repository.EspecialidadeRepository;
import org.serratec.individual.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class MedicoService {

    @Autowired MedicoRepository medicoRepository;

    @Autowired EspecialidadeRepository especialidadeRepository;

    public List<MedicoDTOResponse> findAll(){

        List<Medico> medicos = medicoRepository.findAll();

        List<MedicoDTOResponse> medicosDTO = new ArrayList<>();

        for(Medico medico : medicos){
            medicosDTO.add(new MedicoDTOResponse(medico));
        }
        return medicosDTO;
    }

    public MedicoDTOResponse findByID(Long id){
        
        Medico medico = medicoRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Medico não encontrado"));
        
        return new MedicoDTOResponse(medico);
    }

    @Transactional
    public MedicoDTOResponse inserir (MedicoDTORequest dto){

        if(medicoRepository.existsByCrm(dto.getCrm())){
            throw new ConflictException("CRM já cadastrado");
        }

        if(medicoRepository.existsByEmail(dto.getEmail())){
            throw new ConflictException("Email já cadastrado");
        }

        Medico medico = new Medico();
        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEmail(dto.getEmail());
        medico.setDataContratacao(LocalDate.now());

        if(dto.getEspecialidadesIds() != null && !dto.getEspecialidadesIds().isEmpty()){

            List<Especialidade> especialides = especialidadeRepository.findAllById(dto.getEspecialidadesIds());

            medico.setEspecialidades(especialides);
        }


        medico = medicoRepository.save(medico);

        return new MedicoDTOResponse(medico);
    }
    
    @Transactional
    public MedicoDTOResponse atualizar (Long id, MedicoDTORequest dto){

        Medico medico = medicoRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Medico não encontrado"));

        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEmail(dto.getEmail());

        medico = medicoRepository.save(medico);

        return new MedicoDTOResponse(medico);
            
    }

    @Transactional
    public void deletar(Long id){
        
        Medico medico = medicoRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Medico não econtrado"));

            medicoRepository.delete(medico);
    }


}
