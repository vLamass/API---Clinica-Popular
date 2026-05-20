package org.serratec.individual.dto.response;

import java.time.LocalDate;
import java.time.LocalTime;

import org.serratec.individual.entity.Consulta;
import org.serratec.individual.enums.StatusConsulta;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@JsonPropertyOrder({
    "id",
    "dataConsulta",
    "horaConsulta",
    "medico",
    "paciente",
    "status",
    "observacao"
})


@Getter
@Setter
public class ConsultaDTOResponse {

    @Schema(description = "ID da consulta", example = "10")
    private Long id;

    @Schema(description = "Data da consulta", example = "2026-05-20")
    private LocalDate dataConsulta;

    @Schema(description = "Hora da consulta", example = "14:30:00")
    private LocalTime horaConsulta;

    @Schema(description = "Observação da consulta", example = "Paciente relatou dor de cabeça")
    private String observacao;

    @Schema(description = "Status da consulta", example = "AGENDADA")
    private StatusConsulta status;

    @Schema(description = "Nome do paciente", example = "João Marcelo")
    private String paciente;

    @Schema(description = "Nome do médico", example = "Dra. Maria")
    private String medico;

    public ConsultaDTOResponse(Consulta c){

        this.id = c.getId();
        this.dataConsulta = c.getDataConsulta();
        this.horaConsulta = c.getHoraConsulta();
        this.observacao = c.getObservacao();
        this.status = c.getStatus();

        if(c.getPaciente()!= null){
            this.paciente = c.getPaciente().getNome();
        }

        if(c.getMedico()!= null){
            this.medico = c.getMedico().getNome();
        }
    }
}
