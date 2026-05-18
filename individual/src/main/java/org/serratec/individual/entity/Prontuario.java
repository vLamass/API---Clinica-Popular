package org.serratec.individual.entity;

import java.time.LocalDate;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "prontuarios")
@Schema(description = "Prontuarios dos pacientes")
public class Prontuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do prontuario")
    private Long id;

    @NotBlank
    @Column(name = "historico_medico", columnDefinition = "TEXT")
    @Schema(description = "Histórico médico do paciente",example = "Paciente com histórico de hipertensão e diabetes")
    private String historicoMedico;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Alergias conhecidas do paciente")
    private String alergias;

    @Column(name = "medicamentos_em _uso", columnDefinition = "TEXT")
    @Schema(description = "Medicamentos que o paciente utiliza atualmente")
    private String medicamentosEmUso;

    @Column(columnDefinition = "TEXT")
    @Schema(description = "Observações adicionais sobre o paciente")
    private String observacoes;

    @Column(name = "data_criacao", nullable = false)
    @Schema(description = "Data de criação do prontuário")
    private LocalDate dataCriacao = LocalDate.now();

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;
}
