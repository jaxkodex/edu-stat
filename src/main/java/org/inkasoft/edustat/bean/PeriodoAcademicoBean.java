package org.inkasoft.edustat.bean;

import java.io.Serializable;
import java.util.Date;

import org.inkasoft.edustat.model.PeriodoAcademico;

public class PeriodoAcademicoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idPeriodo;

    private Date periodoFfin;

    private Date periodoFinicio;

    private String periodoNombre;
    
    private String periodoEstado;
    
    private InstitucionEducativaBean institucionEducativa;

    public int getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Date getPeriodoFfin() {
        return periodoFfin;
    }

    public void setPeriodoFfin(Date periodoFfin) {
        this.periodoFfin = periodoFfin;
    }

    public Date getPeriodoFinicio() {
        return periodoFinicio;
    }

    public void setPeriodoFinicio(Date periodoFinicio) {
        this.periodoFinicio = periodoFinicio;
    }

    public String getPeriodoNombre() {
        return periodoNombre;
    }

    public void setPeriodoNombre(String periodoNombre) {
        this.periodoNombre = periodoNombre;
    }

    public InstitucionEducativaBean getInstitucionEducativa() {
        return institucionEducativa;
    }

    public String getPeriodoEstado() {
        return periodoEstado;
    }

    public void setPeriodoEstado(String periodoEstado) {
        this.periodoEstado = periodoEstado;
    }

    public void setInstitucionEducativa(
            InstitucionEducativaBean institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }
    
    public static PeriodoAcademicoBean transformToBean (PeriodoAcademico periodoAcademico) {
        if (periodoAcademico == null) {
            return null;
        }
        PeriodoAcademicoBean periodoAcademicoBean = new PeriodoAcademicoBean();
        
        periodoAcademicoBean.setIdPeriodo(periodoAcademico.getIdPeriodo());
        periodoAcademicoBean.setPeriodoFfin(periodoAcademico.getPeriodoFfin());
        periodoAcademicoBean.setPeriodoFinicio(periodoAcademico.getPeriodoFinicio());
        periodoAcademicoBean.setPeriodoNombre(periodoAcademico.getPeriodoNombre());
        periodoAcademicoBean.setPeriodoEstado(periodoAcademico.getPeriodoEstado());
        
        return periodoAcademicoBean;
    }
}
