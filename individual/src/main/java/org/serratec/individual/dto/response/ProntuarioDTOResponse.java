package org.serratec.individual.dto.response;

import java.time.LocalDate;

import org.serratec.individual.entity.Prontuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProntuarioDTOResponse {

    private Long id;

    private String historicoMedico;

    private String alergias;

    private String medicamentosEmUso;

    private String observacoesProntuario;

    private LocalDate dataCriacao;

    private Long pacienteId;

    private String nomePaciente;

    
    
    public ProntuarioDTOResponse() {
        super();
    }

        public ProntuarioDTOResponse(Prontuario p) {

        this.id = p.getId();
        this.historicoMedico = p.getHistoricoMedico();
        this.alergias = p.getAlergias();
        this.medicamentosEmUso = p.getMedicamentosEmUso();
        this.observacoesProntuario = p.getObservacoesProntuario();
        this.dataCriacao = p.getDataCriacao();

            if (p.getPaciente() != null) {
                this.pacienteId = p.getPaciente().getId();
                this.nomePaciente = p.getPaciente().getNomePaciente();
            }
        }

}

    

    
    



