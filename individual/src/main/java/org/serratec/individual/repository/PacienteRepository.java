package org.serratec.individual.repository;

import org.serratec.individual.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository  extends JpaRepository<Paciente, Long>{

    public Boolean existsByCpf(String cpf);

    public boolean existsByEmail(String email);

}
