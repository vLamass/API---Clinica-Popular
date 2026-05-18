package org.serratec.individual.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import org.serratec.individual.enums.StatusConsulta;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor  //Cria um construtor sem argumentos
@AllArgsConstructor //Cria um construtor com todos os argumentos
@Getter //Cria os Metodos getters
@Setter //Cria os Metodos setters
@Entity
@Table(name = "consultas")
@Schema(description = "Entidade para representar consultas")
public class Consulta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da consulta")
    private Long id;

    @NotBlank
    @Column(name = "data_consulta", nullable = false)
    @Schema(description = "Data da consulta")
    private LocalDate dataConsulta;

    @NotBlank
    @Column(name = "hora_consulta", nullable = false )
    @Schema(description = "Hora da consulta")
    private LocalTime horaConsulta;

    @Column(length = 1000)
    @Schema(description = "Observações da consulta", maxLength = 1000)
    private String observacaoConsulta;

    @Enumerated(EnumType.STRING)
    @Schema(description = "Opções de status", example = "AGENDADA, REALIZADA, CANCELADA, REMARCADA")
    private StatusConsulta status;


    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id")
    private Medico medico;

}
