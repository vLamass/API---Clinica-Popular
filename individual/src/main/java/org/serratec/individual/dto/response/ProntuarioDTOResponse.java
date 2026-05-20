package org.serratec.individual.dto.response;

import java.time.LocalDate;

import org.serratec.individual.entity.Prontuario;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
    "id",
    "pacienteID",
    "nomePaciente",
    "historicoMedico",
    "alergias",
    "medicamentosEmUsos",
    "observacoesProntuario",
    "dataCriacao"
})

@Getter
@Setter
public class ProntuarioDTOResponse {

    @Schema(description = "ID do prontuário", example = "3")
    private Long id;

    @Schema(description = "Histórico médico do paciente", example = "Paciente com hipertensão controlada")
    private String historicoMedico;

    @Schema(description = "Alergias do paciente", example = "Dipirona")
    private String alergias;

    @Schema(description = "Medicamentos em uso", example = "Losartana 50mg")
    private String medicamentosEmUso;

    @Schema(description = "Observações do prontuário", example = "Paciente em acompanhamento regular")
    private String observacoesProntuario;

    @Schema(description = "Data de criação do prontuário", example = "2026-05-20")
    private LocalDate dataCriacao;

    @Schema(description = "ID do paciente", example = "3")
    private Long pacienteId;

    @Schema(description = "Nome do paciente", example = "Neymar Junior")
    private String nomePaciente;

    
    
    public ProntuarioDTOResponse() {
        super();
    }

        public ProntuarioDTOResponse(Prontuario p) {

        this.id = p.getId();
        this.historicoMedico = p.getHistoricoMedico();
        this.alergias = p.getAlergias();
        this.medicamentosEmUso = p.getMedicamentosEmUso();
        this.observacoesProntuario = p.getObservacoesProntuario();
        this.dataCriacao = p.getDataCriacao();

            if (p.getPaciente() != null) {
                this.pacienteId = p.getPaciente().getId();
                this.nomePaciente = p.getPaciente().getNome();
            }
        }

}

    

    
    



