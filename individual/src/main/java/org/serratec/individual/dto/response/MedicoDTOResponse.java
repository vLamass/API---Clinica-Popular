package org.serratec.individual.dto.response;

import java.util.ArrayList;
import java.util.List;

import org.serratec.individual.entity.Especialidade;
import org.serratec.individual.entity.Medico;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
    "id",
    "nome",
    "crm",
    "especialidades"
    
})


@Getter
@Setter
public class MedicoDTOResponse {

    @Schema(description = "ID do médico", example = "11")
    private Long id;
    
    @Schema(description = "Nome do médico", example = "Dr. Marco Silva")
    private String nome;

    @Schema(description = "CRM do médico", example = "123456/SP")
    private String crm;

    @Schema(description = "Especialidades do médico")
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
