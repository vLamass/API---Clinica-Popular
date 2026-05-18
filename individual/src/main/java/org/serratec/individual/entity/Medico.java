package org.serratec.individual.entity;

import java.time.LocalDate;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor  //Cria um construtor sem argumentos
@AllArgsConstructor //Cria um construtor com todos os argumentos
@Getter //Cria os Metodos getters
@Setter //Cria os Metodos setters
@Entity
@Table(name = "medicos")
@Schema(description = "Entidade responsaveil por representar medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do Medico")
    private Long id;

    @NotBlank
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    @Schema(description = "Nome completo do medico", maxLength = 80)
    private String nomeMedico;

    @Column(nullable = false, unique = true)
    @Pattern(regexp = "^\\d{1,6}/(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$", message = "CRM inválido" )
    @Schema(description = "CRM do medico")
    private String crm;

    @Email
    @Column(unique = true, nullable = false)
    @Schema(description = "E-mail do paciente")
    private String email;

    @Column(name = "data_contratacao", nullable = false)
    @Schema(description = "Data da contratação do medico")
    private LocalDate dataContratacao = LocalDate.now();

    //ativo a estudar se implemto

    @OneToMany(mappedBy = "medico")
    private List<Consulta> consultas;

    @ManyToMany
    @JoinTable(
        name = "medico_especialidade",
        joinColumns = @JoinColumn(name = "medico_id"),
        inverseJoinColumns = @JoinColumn(name = "especialidade_id")
    )
        private List<Especialidade> especialidades;



}
