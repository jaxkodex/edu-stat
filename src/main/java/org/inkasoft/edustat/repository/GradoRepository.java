package org.inkasoft.edustat.repository;

import java.util.List;

import org.inkasoft.edustat.model.Grado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradoRepository extends JpaRepository<Grado, Integer> {
	
	public List<Grado> findByNivelIdNivel (Integer idNivel);

}
