package org.serratec.individual.dto.request;

import java.time.LocalDate;
import java.time.LocalTime;

import org.serratec.individual.enums.StatusConsulta;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaDTORequest {

    @NotNull(message = "A data da consulta e obrigatoria")
    @Schema(description = "Data da consulta", example = "2026-05-20")
    private LocalDate dataConsulta;

    @NotNull(message = " A hora da consulta e obrigatoria")
    @Schema(description = "Hora da consulta", example = "14:30:00")
    private LocalTime horaConsulta;

    @Size(max = 1000, message = "A observação deve ter no maximo 1000 caracteres")
    @Schema(description = "Observação da consulta", example = "Paciente relatou dor de cabeça")
    private String observacao;

    @NotNull(message = "O status da consulta e obrigatorio")
    @Schema(description = "Status da consulta", example = "AGENDADA")
    private StatusConsulta status;

    @NotNull(message = " O ID do paciente e obrigatorio")
    @Schema(description = "ID do paciente", example = "1")
    private Long pacienteId;

    @NotNull(message = "O ID do medico e orbigatorio")
    @Schema(description = "ID do médico", example = "2")
    private Long medicoId;

}
