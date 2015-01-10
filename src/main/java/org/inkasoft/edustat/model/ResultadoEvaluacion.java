package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the resultado_evaluacion database table.
 * 
 */
@Entity
@Table(name = "resultado_evaluacion")
@NamedQuery(name = "ResultadoEvaluacion.findAll", query = "SELECT r FROM ResultadoEvaluacion r")
public class ResultadoEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_resultado")
    private int idResultado;

    @Column(name = "resultado_valor")
    private int resultadoValor;

    // bi-directional many-to-one association to CriterioFormato
    @ManyToOne
    @JoinColumn(name = "criterio_formato_id_cformato")
    private CriterioFormato criterioFormato;

    // bi-directional many-to-one association to EvaluacionDocente
    @ManyToOne
    @JoinColumn(name = "evaluacion_docente_id_evaluacion")
    private EvaluacionDocente evaluacionDocente;

    public ResultadoEvaluacion() {
    }

    public int getIdResultado() {
        return this.idResultado;
    }

    public void setIdResultado(int idResultado) {
        this.idResultado = idResultado;
    }

    public int getResultadoValor() {
        return this.resultadoValor;
    }

    public void setResultadoValor(int resultadoValor) {
        this.resultadoValor = resultadoValor;
    }

    public CriterioFormato getCriterioFormato() {
        return this.criterioFormato;
    }

    public void setCriterioFormato(CriterioFormato criterioFormato) {
        this.criterioFormato = criterioFormato;
    }

    public EvaluacionDocente getEvaluacionDocente() {
        return this.evaluacionDocente;
    }

    public void setEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
        this.evaluacionDocente = evaluacionDocente;
    }

}