package org.inkasoft.edustat.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the area_has_docente database table.
 * 
 */
@Entity
@Table(name="area_has_docente")
@NamedQuery(name="AreaHasDocente.findAll", query="SELECT a FROM AreaHasDocente a")
public class AreaHasDocente implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private AreaHasDocentePK id;

    private byte estado;

    //bi-directional many-to-one association to Area
    @ManyToOne
    @JoinColumn(name="area_id_area", insertable=false, updatable=false)
    private Area area;

    //bi-directional many-to-one association to Clase
    @ManyToOne
    @JoinColumn(name="clase_id_clase", insertable=false, updatable=false)
    private Clase clase;

    //bi-directional many-to-one association to Docente
    @ManyToOne
    @JoinColumn(name="docente_id_docente", insertable=false, updatable=false)
    private Docente docente;

    //bi-directional many-to-one association to EvaluacionDocente
    @OneToMany(mappedBy="areaHasDocente")
    private List<EvaluacionDocente> evaluacionDocentes;

    public AreaHasDocente() {
    }

    public AreaHasDocentePK getId() {
        return this.id;
    }

    public void setId(AreaHasDocentePK id) {
        this.id = id;
    }

    public byte getEstado() {
        return this.estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Clase getClase() {
        return this.clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Docente getDocente() {
        return this.docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<EvaluacionDocente> getEvaluacionDocentes() {
        return this.evaluacionDocentes;
    }

    public void setEvaluacionDocentes(List<EvaluacionDocente> evaluacionDocentes) {
        this.evaluacionDocentes = evaluacionDocentes;
    }

    public EvaluacionDocente addEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
        getEvaluacionDocentes().add(evaluacionDocente);
        evaluacionDocente.setAreaHasDocente(this);

        return evaluacionDocente;
    }

    public EvaluacionDocente removeEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
        getEvaluacionDocentes().remove(evaluacionDocente);
        evaluacionDocente.setAreaHasDocente(null);

        return evaluacionDocente;
    }

}