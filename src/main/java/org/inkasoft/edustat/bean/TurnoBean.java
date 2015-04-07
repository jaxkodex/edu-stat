package org.inkasoft.edustat.bean;

import java.io.Serializable;

import org.inkasoft.edustat.model.Turno;

public class TurnoBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idTurno;

    private String turnoName;

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getTurnoName() {
        return turnoName;
    }

    public void setTurnoName(String turnoName) {
        this.turnoName = turnoName;
    }

    public static TurnoBean transformToBean (Turno turno) {
        if (turno == null) {
            return null;
        }
        TurnoBean turnoBean = new TurnoBean();
        turnoBean.setIdTurno(turno.getIdTurno());
        turnoBean.setTurnoName(turno.getTurnoName());
        return turnoBean;
    }

}
