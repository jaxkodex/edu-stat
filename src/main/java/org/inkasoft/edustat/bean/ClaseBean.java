package org.inkasoft.edustat.bean;

import java.io.Serializable;

import org.inkasoft.edustat.model.Clase;

public class ClaseBean implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int idClase;
    
    private boolean habilitado;

    private PeriodoAcademicoBean periodoAcademico;

    private SeccionBean seccion;

    private TurnoBean turno;

    public int getIdClase() {
        return idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public PeriodoAcademicoBean getPeriodoAcademico() {
        return periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademicoBean periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public SeccionBean getSeccion() {
        return seccion;
    }

    public void setSeccion(SeccionBean seccion) {
        this.seccion = seccion;
    }

    public TurnoBean getTurno() {
        return turno;
    }

    public void setTurno(TurnoBean turno) {
        this.turno = turno;
    }
    
    public static ClaseBean transformToBean (Clase clase) {
        if (clase == null) {
            return null;
        }
        ClaseBean claseBean = new ClaseBean();
        claseBean.setIdClase(clase.getIdClase());
        claseBean.setHabilitado(clase.isHabilitado());
        return claseBean;
    }
}
