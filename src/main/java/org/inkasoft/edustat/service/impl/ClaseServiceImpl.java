package org.inkasoft.edustat.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.inkasoft.edustat.bean.ClaseBean;
import org.inkasoft.edustat.bean.GradoBean;
import org.inkasoft.edustat.bean.NivelBean;
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
    private static final Logger LOGGER = Logger.getLogger(ClaseServiceImpl.class);
    
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
        List<Clase> clases = claseRepository.findByPeriodoAcademicoIdPeriodoOrderByTurnoTurnoNameAscSeccionGradoNivelNivelNombreAsc(idPeriodo);
        List<ClaseBean> results = new ArrayList<ClaseBean>();
        for (Clase clase : clases) {
            ClaseBean claseBean = ClaseBean.transformToBean(clase);
            claseBean.setPeriodoAcademico(PeriodoAcademicoBean.transformToBean(clase.getPeriodoAcademico()));
            claseBean.setSeccion(SeccionBean.transformToBean(clase.getSeccion()));
            claseBean.getSeccion().setGrado(GradoBean.transformToBean(clase.getSeccion().getGrado()));
            claseBean.getSeccion().getGrado().setNivel(NivelBean.transformToBean(clase.getSeccion().getGrado().getNivel()));
            claseBean.setTurno(TurnoBean.transformToBean(clase.getTurno()));
            results.add(claseBean);
        }
        if (results.isEmpty()) {
            return generarClasesParaPeriodo(idPeriodo);
        }
        return results;
    }
    
    @Override
    public List<ClaseBean> cargarClasesPorPeriodoTurnoNivel (Integer idPeriodo, Integer idNivel, Integer idTurno) {
        List<Clase> clases = claseRepository.findByPeriodoAcademicoIdPeriodoAndSeccionGradoNivelIdNivelAndTurnoIdTurno(idPeriodo, idNivel, idTurno);
        List<ClaseBean> results = new ArrayList<ClaseBean>();
        for (Clase clase : clases) {
            ClaseBean claseBean = ClaseBean.transformToBean(clase);
            claseBean.setPeriodoAcademico(PeriodoAcademicoBean.transformToBean(clase.getPeriodoAcademico()));
            claseBean.setSeccion(SeccionBean.transformToBean(clase.getSeccion()));
            claseBean.getSeccion().setGrado(GradoBean.transformToBean(clase.getSeccion().getGrado()));
            claseBean.getSeccion().getGrado().setNivel(NivelBean.transformToBean(clase.getSeccion().getGrado().getNivel()));
            claseBean.setTurno(TurnoBean.transformToBean(clase.getTurno()));
            results.add(claseBean);
        }
        if (results.isEmpty()) {
            return generaClases (idPeriodo, idNivel, idTurno);
        }
        return results;
    }
    
    private List<ClaseBean> generaClases (Integer idPeriodo, Integer idNivel, Integer idTurno) {
        List<Clase> clases = new ArrayList<Clase>();
        List<ClaseBean> results = new ArrayList<ClaseBean>();
        Turno turno = turnoRepository.findOne(idTurno);
        PeriodoAcademico periodoAcademico = periodoAcademicoRepository.findOne(idPeriodo);
        List<Seccion> secciones = seccionRepository.findByGradoNivelIdNivel(idNivel);
        for (Seccion seccion : secciones) {
            Clase clase = new Clase();
            clase.setSeccion(seccion);
            clase.setPeriodoAcademico(periodoAcademico);
            clase.setTurno(turno);
            clases.add(clase);
        }
        claseRepository.save(clases);
        for (Clase clase : clases) {
            ClaseBean claseBean = ClaseBean.transformToBean(clase);
            claseBean.setPeriodoAcademico(PeriodoAcademicoBean.transformToBean(clase.getPeriodoAcademico()));
            claseBean.setSeccion(SeccionBean.transformToBean(clase.getSeccion()));
            claseBean.getSeccion().setGrado(GradoBean.transformToBean(clase.getSeccion().getGrado()));
            claseBean.getSeccion().getGrado().setNivel(NivelBean.transformToBean(clase.getSeccion().getGrado().getNivel()));
            claseBean.setTurno(TurnoBean.transformToBean(clase.getTurno()));
            results.add(claseBean);
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
            LOGGER.debug("*Generar clases*");
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
            LOGGER.debug("Clases generadas: "+clases.size());
        }
        for (Clase clase : clases) {
            ClaseBean claseBean = ClaseBean.transformToBean(clase);
            claseBean.setPeriodoAcademico(PeriodoAcademicoBean.transformToBean(clase.getPeriodoAcademico()));
            claseBean.setSeccion(SeccionBean.transformToBean(clase.getSeccion()));
            claseBean.getSeccion().setGrado(GradoBean.transformToBean(clase.getSeccion().getGrado()));
            claseBean.getSeccion().getGrado().setNivel(NivelBean.transformToBean(clase.getSeccion().getGrado().getNivel()));
            claseBean.setTurno(TurnoBean.transformToBean(clase.getTurno()));
            results.add(claseBean);
        }
        return results;
    }

    @Override
    public ClaseBean actualizarClase(Clase clase) {
        claseRepository.save(clase);
        ClaseBean claseBean = ClaseBean.transformToBean(clase);
        claseBean.setPeriodoAcademico(PeriodoAcademicoBean.transformToBean(clase.getPeriodoAcademico()));
        claseBean.setSeccion(SeccionBean.transformToBean(clase.getSeccion()));
        claseBean.setTurno(TurnoBean.transformToBean(clase.getTurno()));
        return claseBean;
    }

}
