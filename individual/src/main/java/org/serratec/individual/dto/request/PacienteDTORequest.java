package org.serratec.individual.dto.request;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTORequest {

    @NotBlank(message = "O nome é obrigatório")
    @Schema(description = "Nome do paciente", example = "João Silva")
    private String nome;

    @NotBlank(message = "O CPF é obrigatório")
    @CPF(message = "CPF inválido")
    @Schema(description = "CPF do paciente", example = "123.456.789-00")
    private String cpf;

    @NotBlank(message = "O email é obrigatório")
    @Email(message = "Email inválido")
    @Schema(description = "Email do paciente", example = "paciente@email.com")
    private String email;

    @NotNull(message = "A data de nascimento é obrigatória")
    @Schema(description = "Data de nascimento do paciente", example = "1990-05-20")
    private LocalDate dataNascimento;
}
