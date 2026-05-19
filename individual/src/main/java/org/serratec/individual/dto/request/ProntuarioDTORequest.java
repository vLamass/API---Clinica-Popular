package org.serratec.individual.dto.request;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProntuarioDTORequest {
    
    @NotBlank
    private String historicoMedico;

    private String alergias;

    private String medicamentoEmUso;

    private String observacoesProntuario;

    private Long pacienteId;
}
