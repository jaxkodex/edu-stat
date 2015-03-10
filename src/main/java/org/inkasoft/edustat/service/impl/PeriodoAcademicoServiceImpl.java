package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.inkasoft.edustat.bean.InstitucionEducativaBean;
import org.inkasoft.edustat.bean.PeriodoAcademicoBean;
import org.inkasoft.edustat.model.PeriodoAcademico;
import org.inkasoft.edustat.repository.PeriodoAcademicoRepository;
import org.inkasoft.edustat.service.PeriodoAcademicoService;
import org.inkasoft.edustat.util.PeriodoAcademicoEstado;
import org.inkasoft.edustat.util.exceptions.PeriodoAcademicoAbiertoYaExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PeriodoAcademicoServiceImpl implements PeriodoAcademicoService {
    @Autowired
    private PeriodoAcademicoRepository periodoAcademicoRepository;

	@Override
	public PeriodoAcademicoBean findById(Integer idPeriodo) {
		PeriodoAcademico periodoAcademico = periodoAcademicoRepository.findOne(idPeriodo);
        PeriodoAcademicoBean periodoBean = PeriodoAcademicoBean.transformToBean(periodoAcademico);
        periodoBean.setInstitucionEducativa(InstitucionEducativaBean.transformToBean(periodoAcademico.getInstitucionEducativa()));
        return periodoBean;
	}

	@Override
	public void delete(Integer idPeriodo) {
		periodoAcademicoRepository.delete(idPeriodo);
	}

    @Override
    public PeriodoAcademicoBean aperturarPeriodoAcademico(PeriodoAcademico periodoAcademico) throws PeriodoAcademicoAbiertoYaExisteException {
        List<PeriodoAcademico> periodosAbiertos = periodoAcademicoRepository.findByInstitucionEducativaIdIeAndPeriodoEstado(periodoAcademico.getInstitucionEducativa().getIdIe(), PeriodoAcademicoEstado.PERIODO_ABIERTO.getCodEstado());
        if (!periodosAbiertos.isEmpty()) {
            throw new PeriodoAcademicoAbiertoYaExisteException("El periodo "+periodoAcademico.getPeriodoNombre()+" para la institución educativa "+periodoAcademico.getInstitucionEducativa().getIeNombre()+" no puede ser creado por que ya existe un periodo abierto en el sistema.");
        }
        periodoAcademico.setPeriodoEstado(PeriodoAcademicoEstado.PERIODO_ABIERTO.getCodEstado());
        periodoAcademicoRepository.save(periodoAcademico);
        PeriodoAcademicoBean periodoBean = PeriodoAcademicoBean.transformToBean(periodoAcademico);
        periodoBean.setInstitucionEducativa(InstitucionEducativaBean.transformToBean(periodoAcademico.getInstitucionEducativa()));
        return periodoBean;
    }

    @Override
    public List<PeriodoAcademicoBean> listByInstitucionEducativa(Integer idIe) {
        List<PeriodoAcademico> periodos = periodoAcademicoRepository.findByInstitucionEducativaIdIe(idIe);
        List<PeriodoAcademicoBean> periodosBean = new ArrayList<PeriodoAcademicoBean>();
        for (PeriodoAcademico periodo : periodos) {
            PeriodoAcademicoBean periodoBean = PeriodoAcademicoBean.transformToBean(periodo);
            periodoBean.setInstitucionEducativa(InstitucionEducativaBean.transformToBean(periodo.getInstitucionEducativa()));
            periodosBean.add(periodoBean);
        }
        return periodosBean;
    }

	@Override
	public PeriodoAcademicoBean updatePeriodoAcademico(PeriodoAcademico periodoAcademico) throws PeriodoAcademicoAbiertoYaExisteException {
        List<PeriodoAcademico> periodosAbiertos = periodoAcademicoRepository.findByInstitucionEducativaIdIeAndPeriodoEstado(periodoAcademico.getInstitucionEducativa().getIdIe(), PeriodoAcademicoEstado.PERIODO_ABIERTO.getCodEstado());
        if ((!periodosAbiertos.isEmpty() && PeriodoAcademicoEstado.PERIODO_ABIERTO.getCodEstado().equals(periodoAcademico.getPeriodoEstado())) 
        	&& (periodosAbiertos.size() == 1 && periodosAbiertos.get(0).getIdPeriodo() != periodoAcademico.getIdPeriodo())) {
        		throw new PeriodoAcademicoAbiertoYaExisteException("El periodo "+periodoAcademico.getPeriodoNombre()+" para la institución educativa "+periodoAcademico.getInstitucionEducativa().getIeNombre()+" no puede ser creado por que ya existe un periodo abierto en el sistema.");
        }
        periodoAcademicoRepository.save(periodoAcademico);
        PeriodoAcademicoBean periodoBean = PeriodoAcademicoBean.transformToBean(periodoAcademico);
        periodoBean.setInstitucionEducativa(InstitucionEducativaBean.transformToBean(periodoAcademico.getInstitucionEducativa()));
        return periodoBean;
	}
    
}
