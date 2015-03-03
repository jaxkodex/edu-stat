package org.inkasoft.edustat.repository;

import java.util.List;

import org.inkasoft.edustat.model.Clase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaseRepository extends JpaRepository<Clase, Integer> {

	public List<Clase> findByPeriodoAcademicoIdPeriodo (Integer idPeriodo);
	public List<Clase> findByPeriodoAcademicoIdPeriodoOrderByTurnoTurnoNameAscSeccionGradoNivelNivelNombreAsc (Integer idPeriodo);
}
