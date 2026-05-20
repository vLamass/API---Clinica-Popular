package org.serratec.individual.dto.response;

import org.serratec.individual.entity.Especialidade;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
    "id",
    "nome",
    "descricaoEspecilidade"
})


@Getter
@Setter
public class EspecialidadesDTOResponse {

    @Schema(description = "ID da especialidade", example = "1")
    private Long id;

    @Schema(description = "Nome da especialidade", example = "Cardiologia")
    private String nome;

    @Schema(description = "Descrição da especialidade", example = "Especialidade responsável pelo coração e sistema cardiovascular")
    private String descricaoEspecialidade;

    public EspecialidadesDTOResponse(Especialidade especialidade){

        this.id = especialidade.getId();
        this.nome = especialidade.getNome();
        this.descricaoEspecialidade = especialidade.getDescricaoEspecialidade();
    }
}
