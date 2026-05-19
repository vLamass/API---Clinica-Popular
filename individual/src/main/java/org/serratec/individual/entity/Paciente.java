package org.serratec.individual.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
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
@Table(name = "pacientes")
@Schema(description = "Entidade responsavel por representar um paciente")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do paciente")
    private Long id;

    @NotBlank
    @Size(max = 80)
    @Column(nullable = false, length = 80)
    @Schema(description = "Nome completo do paciente", maxLength = 80)
    private String nome;

    @CPF
    @Column(length = 11)
    @Schema(description = "CPF do paciente", minLength = 11, maxLength = 11)
    private String cpf;

    @Email
    @Column(unique = true)
    @Schema(description = "E-mail do paciente")
    private String email;

    
    @Past
    @Column(name = "data_nascimento", nullable = false)
    @Schema(description = "Data de nascimento do paciente")
    private LocalDate dataNascimento;

    @OneToOne(mappedBy = "paciente")
    private Prontuario prontuario;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas;

    

    

}
