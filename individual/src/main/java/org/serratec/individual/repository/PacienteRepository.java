package org.serratec.individual.repository;

import org.serratec.individual.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository  extends JpaRepository<Paciente, Long>{

}
