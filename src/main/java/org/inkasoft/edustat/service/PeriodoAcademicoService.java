package org.inkasoft.edustat.service;

import java.util.List;

import org.inkasoft.edustat.bean.PeriodoAcademicoBean;
import org.inkasoft.edustat.model.PeriodoAcademico;
import org.inkasoft.edustat.util.exceptions.PeriodoAcademicoAbiertoYaExisteException;

public interface PeriodoAcademicoService {
    
    public List<PeriodoAcademicoBean> listByInstitucionEducativa (Integer idIe);
    public PeriodoAcademicoBean aperturarPeriodoAcademico (PeriodoAcademico periodoAcademico) throws PeriodoAcademicoAbiertoYaExisteException;

}
