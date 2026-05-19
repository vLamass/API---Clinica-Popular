package org.serratec.individual.dto.response;

import java.time.LocalDate;

import org.serratec.individual.entity.Paciente;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTOResponse {

    private Long id;
    
    private String nome;

    private LocalDate dataNascimento;
    
    public PacienteDTOResponse() {
    }

    public PacienteDTOResponse(Paciente p){
        
        this.id = p.getId();
        this.nome = p.getNome();
        this.dataNascimento = p.getDataNascimento();
    }


    
}
