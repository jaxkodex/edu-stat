package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conclusion_evaluacion database table.
 * 
 */
@Entity
@Table(name="conclusion_evaluacion")
@NamedQuery(name="ConclusionEvaluacion.findAll", query="SELECT c FROM ConclusionEvaluacion c")
public class ConclusionEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_conclusion")
    private int idConclusion;

    @Column(name="conclusion_descripcion")
    private String conclusionDescripcion;

    //bi-directional many-to-one association to EvaluacionDocente
    @ManyToOne
    @JoinColumn(name="evaluacion_docente_id_evaluacion")
    private EvaluacionDocente evaluacionDocente;

    public ConclusionEvaluacion() {
    }

    public int getIdConclusion() {
        return this.idConclusion;
    }

    public void setIdConclusion(int idConclusion) {
        this.idConclusion = idConclusion;
    }

    public String getConclusionDescripcion() {
        return this.conclusionDescripcion;
    }

    public void setConclusionDescripcion(String conclusionDescripcion) {
        this.conclusionDescripcion = conclusionDescripcion;
    }

    public EvaluacionDocente getEvaluacionDocente() {
        return this.evaluacionDocente;
    }

    public void setEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
        this.evaluacionDocente = evaluacionDocente;
    }

}