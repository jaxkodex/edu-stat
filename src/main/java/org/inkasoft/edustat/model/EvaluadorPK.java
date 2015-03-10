package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the evaluador database table.
 * 
 */
@Embeddable
public class EvaluadorPK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;
    private static final int PRIME = 31;
    private static final int BASE_HASH = 17;

    @Column(name="monitoreo_id_monitoreo", insertable=false, updatable=false)
    private int monitoreoIdMonitoreo;

    @Column(name="docente_id_docente", insertable=false, updatable=false)
    private int docenteIdDocente;

    public EvaluadorPK() {
    }
    public int getMonitoreoIdMonitoreo() {
        return this.monitoreoIdMonitoreo;
    }
    public void setMonitoreoIdMonitoreo(int monitoreoIdMonitoreo) {
        this.monitoreoIdMonitoreo = monitoreoIdMonitoreo;
    }
    public int getDocenteIdDocente() {
        return this.docenteIdDocente;
    }
    public void setDocenteIdDocente(int docenteIdDocente) {
        this.docenteIdDocente = docenteIdDocente;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof EvaluadorPK)) {
            return false;
        }
        EvaluadorPK castOther = (EvaluadorPK)other;
        return 
            (this.monitoreoIdMonitoreo == castOther.monitoreoIdMonitoreo)
            && (this.docenteIdDocente == castOther.docenteIdDocente);
    }

    public int hashCode() {
        int hash = BASE_HASH;
        hash = hash * PRIME + this.monitoreoIdMonitoreo;
        hash = hash * PRIME + this.docenteIdDocente;
        
        return hash;
    }
}