package org.serratec.individual.entity;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
@Table(name = "especialidades")
@Schema(description = "Entidade de especialidades")
public class Especialidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da espacialidade")
    private Long id;


    @NotBlank
    @Column(nullable = false, length = 60, unique = true)
    @Schema(description = "Nome da especialidade", example = "Cardiologia, Pediatria, Dermatologia, Ortopedia, Clínico Geral")
    private String nome;

    @NotBlank
    @Column(nullable = false,length = 500)
    @Schema(description = "Descrição da Especialidade")
    private String descricaoEspecialidade;

    @ManyToMany(mappedBy = "especialidades")
    private List<Medico> medicos;


}
