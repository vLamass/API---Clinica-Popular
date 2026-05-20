package org.serratec.individual.dto.response;

import org.serratec.individual.entity.Especialidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspecialidadesDTOResponse {

    private Long id;

    private String nome;

    public EspecialidadesDTOResponse(Especialidade especialidade){

        this.id = especialidade.getId();
        this.nome = especialidade.getNome();
    }
}
