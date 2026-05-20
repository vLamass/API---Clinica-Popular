package org.serratec.individual.dto.response;

import java.time.LocalDate;

import org.serratec.individual.entity.Paciente;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({
    "id",
    "nome",
    "dataNascimento"
})
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PacienteDTOResponse {

    @Schema(description = "ID do paciente", example = "17")
    private Long id;
    
    @Schema(description = "Nome do paciente", example = "Felipe Melo")
    private String nome;

    @Schema(description = "Data de nascimento do paciente", example = "1990-05-20")
    private LocalDate dataNascimento;
    

    public PacienteDTOResponse(Paciente p){
        
        this.id = p.getId();
        this.nome = p.getNome();
        this.dataNascimento = p.getDataNascimento();
    }


    
}
