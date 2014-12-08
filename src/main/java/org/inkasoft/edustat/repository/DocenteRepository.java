package org.inkasoft.edustat.repository;

import java.util.List;

import org.inkasoft.edustat.model.Docente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocenteRepository extends JpaRepository<Docente, Integer> {
	
	public List<Docente> findByInstitucionEducativaHasDocentesInstitucionEducativaIdIe (Integer idIe);

}
