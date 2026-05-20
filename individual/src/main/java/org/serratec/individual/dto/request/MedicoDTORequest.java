package org.serratec.individual.dto.request;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MedicoDTORequest {

    @NotBlank
    @Size(max = 80, message = "O nome deve ter no máximo 80 caracteres" )
    @Schema(description = "Nome do médico", example = "Dr. João Marcos")
    private String nome;

    @NotBlank
    @Pattern(regexp = "^\\d{1,6}/(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$", message = "CRM inválido" )
    @Schema(description = "CRM do médico", example = "123456/SP")
    private String crm;

    @Email
    @NotBlank
    @Schema(description = "Email do médico", example = "medico@email.com")
    private String email;

    @Schema(description = "Lista de IDs das especialidades do médico",example = "[1, 2, 3]")
    private List<Long> especialidadesIds;
    
}