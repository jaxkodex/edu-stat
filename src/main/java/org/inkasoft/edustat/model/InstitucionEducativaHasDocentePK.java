package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the institucion_educativa_has_docente database table.
 * 
 */
@Embeddable
public class InstitucionEducativaHasDocentePK implements Serializable {
    private static final int PRIME = 31;
    private static final int HASH_BASE = 17;
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    //@Column(name="institucion_educativa_id_ie", insertable=false, updatable=false)
    @Column(name="institucion_educativa_id_ie")
    private int institucionEducativaIdIe;

    //@Column(name="docente_id_docente", insertable=false, updatable=false)
    @Column(name="docente_id_docente")
    private int docenteIdDocente;

    public InstitucionEducativaHasDocentePK() {
    }
    public int getInstitucionEducativaIdIe() {
        return this.institucionEducativaIdIe;
    }
    public void setInstitucionEducativaIdIe(int institucionEducativaIdIe) {
        this.institucionEducativaIdIe = institucionEducativaIdIe;
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
        if (!(other instanceof InstitucionEducativaHasDocentePK)) {
            return false;
        }
        InstitucionEducativaHasDocentePK castOther = (InstitucionEducativaHasDocentePK)other;
        return 
            (this.institucionEducativaIdIe == castOther.institucionEducativaIdIe)
            && (this.docenteIdDocente == castOther.docenteIdDocente);
    }

    public int hashCode() {
        final int prime = PRIME;
        int hash = HASH_BASE;
        hash = hash * prime + this.institucionEducativaIdIe;
        hash = hash * prime + this.docenteIdDocente;
        
        return hash;
    }
}