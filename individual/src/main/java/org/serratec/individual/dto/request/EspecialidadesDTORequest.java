package org.serratec.individual.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EspecialidadesDTORequest {
    
    @NotBlank(message = "O nome da especialidade é obrigatorio")
    @Size(max = 60, message = "O nome deve ter no maximo 60 caracteres ")
    @Schema(description = "Nome da especialidade", example = "Cardiologia")
    private String nome;

    @NotBlank(message = "A descrição da especialidade e obrigatoria")
    @Size(max = 500, message = "A descrção deve ter no maximo 500 caracteres")
    @Schema(description = "Descrição da especialidade", example = "Especialidade responsável pelo coração e sistema cardiovascular")
    private String descricaoEspecialidade;
}   
