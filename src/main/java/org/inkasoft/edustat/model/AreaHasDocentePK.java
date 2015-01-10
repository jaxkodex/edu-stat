package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the area_has_docente database table.
 * 
 */
@Embeddable
public class AreaHasDocentePK implements Serializable {
    private static final int PRIME = 31;
    private static final int HASH_BASE = 17;
    private static final long serialVersionUID = 1L;

    @Column(name="area_id_area")
    private int areaIdArea;

    @Column(name="docente_id_docente")
    private int docenteIdDocente;

    @Column(name="clase_id_clase")
    private int claseIdClase;

    public AreaHasDocentePK() {
    }
    public int getAreaIdArea() {
        return this.areaIdArea;
    }
    public void setAreaIdArea(int areaIdArea) {
        this.areaIdArea = areaIdArea;
    }
    public int getDocenteIdDocente() {
        return this.docenteIdDocente;
    }
    public void setDocenteIdDocente(int docenteIdDocente) {
        this.docenteIdDocente = docenteIdDocente;
    }
    public int getClaseIdClase() {
        return this.claseIdClase;
    }
    public void setClaseIdClase(int claseIdClase) {
        this.claseIdClase = claseIdClase;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AreaHasDocentePK)) {
            return false;
        }
        AreaHasDocentePK castOther = (AreaHasDocentePK)other;
        return 
            (this.areaIdArea == castOther.areaIdArea)
            && (this.docenteIdDocente == castOther.docenteIdDocente)
            && (this.claseIdClase == castOther.claseIdClase);
    }

    public int hashCode() {
        final int prime = PRIME;
        int hash = HASH_BASE;
        hash = hash * prime + this.areaIdArea;
        hash = hash * prime + this.docenteIdDocente;
        hash = hash * prime + this.claseIdClase;
        
        return hash;
    }
}