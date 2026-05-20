package org.serratec.individual.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.individual.dto.request.EspecialidadesDTORequest;
import org.serratec.individual.dto.response.EspecialidadesDTOResponse;
import org.serratec.individual.entity.Especialidade;
import org.serratec.individual.exception.NotFoundException;
import org.serratec.individual.repository.EspecialidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;



@Service
public class EspecialidadeService {

    @Autowired 
    private EspecialidadeRepository especialidadeRepository;

    public List<EspecialidadesDTOResponse> findAll(){

        List<Especialidade> especialidades = especialidadeRepository.findAll();

        List<EspecialidadesDTOResponse> especialidadesDTO = new ArrayList<>();

        for(Especialidade especialidade:especialidades){
            especialidadesDTO.add(new EspecialidadesDTOResponse(especialidade));
        }
            return especialidadesDTO;
    }

    public EspecialidadesDTOResponse findById(Long id){

        Especialidade especialidade = especialidadeRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Especialidade não encontrada"));
        
        return new EspecialidadesDTOResponse(especialidade);   
    }

    @Transactional
    public EspecialidadesDTOResponse inserir( EspecialidadesDTORequest dto){

        Especialidade especialidade = new Especialidade();

        especialidade.setNome(dto.getNome());
        especialidade.setDescricaoEspecialidade(dto.getDescricaoEspecialidade());

        especialidade = especialidadeRepository.save(especialidade);

        return new EspecialidadesDTOResponse(especialidade);
    }

    @Transactional
    public EspecialidadesDTOResponse atualizar (Long id, EspecialidadesDTORequest dto){

        Especialidade especialidade = especialidadeRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Especialidade não encontrada"));

        especialidade.setNome(dto.getNome());
        especialidade.setDescricaoEspecialidade(dto.getDescricaoEspecialidade());
        
        especialidade = especialidadeRepository.save(especialidade);

        return new EspecialidadesDTOResponse(especialidade);

    }

    @Transactional
    public void deletar (Long id){

        Especialidade especialidade = especialidadeRepository.findById(id)
            .orElseThrow(()-> new NotFoundException("Especialidade não encontrada"));

        especialidadeRepository.delete(especialidade);
    }


}
