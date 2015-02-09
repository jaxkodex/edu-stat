package org.inkasoft.edustat.model;

import java.io.Serializable;

import javax.persistence.*;

import org.inkasoft.edustat.model.EvaluadorPK;

import java.util.List;


/**
 * The persistent class for the evaluador database table.
 * 
 */
@Entity
@Table(name="evaluador")
@NamedQuery(name="Evaluador.findAll", query="SELECT e FROM Evaluador e")
public class Evaluador implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EvaluadorPK id;

    @Column(name="evaluador_estado")
    private byte estado;

    //bi-directional many-to-one association to EvaluacionDocente
    @OneToMany(mappedBy="evaluador")
    private List<EvaluacionDocente> evaluacionDocentes;

    //bi-directional many-to-one association to Docente
    @ManyToOne
    @JoinColumn(name="docente_id_docente",referencedColumnName="id_docente", insertable=false, updatable=false)
    private Docente docente;

    //bi-directional many-to-one association to Monitoreo
    @ManyToOne
    @JoinColumn(name="monitoreo_id_monitoreo",referencedColumnName="id_monitoreo", insertable=false, updatable=false)
    private Monitoreo monitoreo;

    public Evaluador() {
    }

    public EvaluadorPK getIdEvaluador() {
        return this.id;
    }

    public void setIdEvaluador(EvaluadorPK id) {
        this.id = id;
    }

    public byte getEstado() {
        return this.estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public List<EvaluacionDocente> getEvaluacionDocentes() {
        return this.evaluacionDocentes;
    }

    public void setEvaluacionDocentes(List<EvaluacionDocente> evaluacionDocentes) {
        this.evaluacionDocentes = evaluacionDocentes;
    }

    public EvaluacionDocente addEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
        getEvaluacionDocentes().add(evaluacionDocente);
        evaluacionDocente.setEvaluador(this);

        return evaluacionDocente;
    }

    public EvaluacionDocente removeEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
        getEvaluacionDocentes().remove(evaluacionDocente);
        evaluacionDocente.setEvaluador(null);

        return evaluacionDocente;
    }

    public Docente getDocente() {
        return this.docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public Monitoreo getMonitoreo() {
        return this.monitoreo;
    }

    public void setMonitoreo(Monitoreo monitoreo) {
        this.monitoreo = monitoreo;
    }

}