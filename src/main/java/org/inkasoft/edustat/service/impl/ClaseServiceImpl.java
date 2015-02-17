package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.inkasoft.edustat.bean.ClaseBean;
import org.inkasoft.edustat.bean.PeriodoAcademicoBean;
import org.inkasoft.edustat.bean.SeccionBean;
import org.inkasoft.edustat.bean.TurnoBean;
import org.inkasoft.edustat.model.Clase;
import org.inkasoft.edustat.model.PeriodoAcademico;
import org.inkasoft.edustat.model.Seccion;
import org.inkasoft.edustat.model.Turno;
import org.inkasoft.edustat.repository.ClaseRepository;
import org.inkasoft.edustat.repository.PeriodoAcademicoRepository;
import org.inkasoft.edustat.repository.SeccionRepository;
import org.inkasoft.edustat.repository.TurnoRepository;
import org.inkasoft.edustat.service.ClaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClaseServiceImpl implements ClaseService {
	@Autowired
	private ClaseRepository claseRepository;
	@Autowired
	private SeccionRepository seccionRepository;
	@Autowired
	private PeriodoAcademicoRepository periodoAcademicoRepository;
	@Autowired
	private TurnoRepository turnoRepository;

	@Override
	public List<ClaseBean> cargarClasesPorPeriodo(Integer idPeriodo) {
		List<Clase> clases = claseRepository.findByPeriodoAcademicoIdPeriodo(idPeriodo);
		List<ClaseBean> results = new ArrayList<ClaseBean>();
		for (Clase clase : clases) {
			ClaseBean claseBean = ClaseBean.transformToBean(clase);
			claseBean.setPeriodoAcademico(PeriodoAcademicoBean.transformToBean(clase.getPeriodoAcademico()));
			claseBean.setSeccion(SeccionBean.transformToBean(clase.getSeccion()));
			claseBean.setTurno(TurnoBean.transformToBean(clase.getTurno()));
			results.add(claseBean);
		}
		if (results.isEmpty()) {
			return generarClasesParaPeriodo(idPeriodo);
		}
		return results;
	}

	@Override
	public List<ClaseBean> generarClasesParaPeriodo(Integer idPeriodo) {
		List<Clase> clases = claseRepository.findByPeriodoAcademicoIdPeriodo(idPeriodo);
		List<Seccion> secciones;
		List<ClaseBean> results = new ArrayList<ClaseBean>();
		List<Turno> turnos;
		PeriodoAcademico periodoAcademico;
		if (clases.isEmpty()) {
			periodoAcademico = periodoAcademicoRepository.findOne(idPeriodo);
			turnos = turnoRepository.findAll();
			secciones = seccionRepository.findAll();
			clases = new ArrayList<Clase> ();
			for (Seccion seccion : secciones) {
				for (Turno turno : turnos) {
					Clase clase = new Clase();
					clase.setSeccion(seccion);
					clase.setPeriodoAcademico(periodoAcademico);
					clase.setTurno(turno);
					clases.add(clase);
				}
			}
			claseRepository.save(clases);
		}
		for (Clase clase : clases) {
			ClaseBean claseBean = ClaseBean.transformToBean(clase);
			claseBean.setPeriodoAcademico(PeriodoAcademicoBean.transformToBean(clase.getPeriodoAcademico()));
			claseBean.setSeccion(SeccionBean.transformToBean(clase.getSeccion()));
			claseBean.setTurno(TurnoBean.transformToBean(clase.getTurno()));
			results.add(claseBean);
		}
		return results;
	}

}
