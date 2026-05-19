package org.serratec.individual.repository;

import org.serratec.individual.entity.Especialidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadeRepository  extends JpaRepository<Especialidade, Long>{

}
