package org.inkasoft.edustat.repository;

import java.util.List;

import org.inkasoft.edustat.model.PeriodoAcademico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoAcademicoRepository extends JpaRepository<PeriodoAcademico, Integer> {

    public List<PeriodoAcademico> findByInstitucionEducativaIdIe (Integer idIe);
    public List<PeriodoAcademico> findByInstitucionEducativaIdIeAndPeriodoEstado (Integer idIe, String periodEstado);
    
}
