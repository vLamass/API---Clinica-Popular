package org.serratec.individual.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProntuarioDTORequest {
    
    @NotBlank(message = "O histórico médico é obrigatório")
    @Schema(description = "Histórico médico do paciente", example = "Paciente com histórico de hipertensão")
    private String historicoMedico;

    @Schema(description = "Alergias do paciente", example = "Dipirona")
    private String alergias;
    
    @Schema(description = "Medicamentos em uso", example = "Losartana 50mg")
    private String medicamentoEmUso;
    
    @Schema(description = "Observações do prontuário", example = "Paciente em acompanhamento regular")
    private String observacoesProntuario;

    @NotNull(message = "O ID do paciente é obrigatório")
    @Schema(description = "ID do paciente", example = "1")
    private Long pacienteId;
}
