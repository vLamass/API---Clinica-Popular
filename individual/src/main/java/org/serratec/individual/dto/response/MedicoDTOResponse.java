package org.serratec.individual.dto.response;

import java.util.ArrayList;
import java.util.List;

import org.serratec.individual.entity.Especialidade;
import org.serratec.individual.entity.Medico;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MedicoDTOResponse {

    private Long id;
    
    private String nome;

    private String crm;

    private List<EspecialidadesDTOResponse> especialidades;

    public MedicoDTOResponse(Medico m){
        
        this.id = m.getId();
        this.nome = m.getNome();
        this.crm = m.getCrm();
    
    
        List<EspecialidadesDTOResponse> lista = new ArrayList<>();

        for (Especialidade esp : m.getEspecialidades()) {
            lista.add(new EspecialidadesDTOResponse(esp));
        }
            this.especialidades = lista;
    
    
    
    }

    


}   
