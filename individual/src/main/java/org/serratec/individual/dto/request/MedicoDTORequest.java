package org.serratec.individual.dto.request;

import java.util.List;

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
    @Size(max = 80)
    private String nome;

    @NotBlank
    @Pattern(regexp = "^\\d{1,6}/(AC|AL|AP|AM|BA|CE|DF|ES|GO|MA|MT|MS|MG|PA|PB|PR|PE|PI|RJ|RN|RS|RO|RR|SC|SP|SE|TO)$", message = "CRM inválido" )
    private String crm;

    @Email
    @NotBlank
    private String email;

    private List<Long> especialidadesIds;
    
}