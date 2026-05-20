package org.serratec.individual.dto.response;

import java.time.LocalDate;

import org.serratec.individual.entity.Paciente;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
    "id",
    "nome",
    "dataNascimento"
})

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
