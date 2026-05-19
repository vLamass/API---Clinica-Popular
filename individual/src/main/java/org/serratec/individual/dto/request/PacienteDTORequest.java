package org.serratec.individual.dto.request;

import java.time.LocalDate;

import org.hibernate.validator.constraints.br.CPF;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PacienteDTORequest {

    @NotBlank
    private String nome;

    @CPF
    private String cpf;

    @Email
    private String email;

    @NotNull
    private LocalDate dataNascimento;
}
