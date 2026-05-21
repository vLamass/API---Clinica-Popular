package org.serratec.individual.enums;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Status da consulta")
public enum StatusConsulta {
    AGENDADA,
    REALIZADA,
    CANCELADA,
    REMARCADA;
}
