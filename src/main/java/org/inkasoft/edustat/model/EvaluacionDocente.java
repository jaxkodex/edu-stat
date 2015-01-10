package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evaluacion_docente database table.
 * 
 */
@Entity
@Table(name="evaluacion_docente")
@NamedQuery(name="EvaluacionDocente.findAll", query="SELECT e FROM EvaluacionDocente e")
public class EvaluacionDocente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_evaluacion")
    private int idEvaluacion;

    @Column(name="evaluacion_frealizada")
    private String evaluacionFrealizada;

    //bi-directional many-to-one association to ConclusionEvaluacion
    @OneToMany(mappedBy="evaluacionDocente")
    private List<ConclusionEvaluacion> conclusionEvaluacions;

    //bi-directional many-to-one association to AreaHasDocente
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="area_has_docente_area_id_area", referencedColumnName="area_id_area"),
        @JoinColumn(name="area_has_docente_clase_id_clase", referencedColumnName="clase_id_clase"),
        @JoinColumn(name="area_has_docente_docente_id_docente", referencedColumnName="docente_id_docente")
        })
    private AreaHasDocente areaHasDocente;

    //bi-directional many-to-one association to Evaluador
    @ManyToOne
    private Evaluador evaluador;

    //bi-directional many-to-one association to FormatoFichaEvaluacion
    @ManyToOne
    @JoinColumn(name="formato_ficha_evaluacion_id_formato")
    private FormatoFichaEvaluacion formatoFichaEvaluacion;

    //bi-directional many-to-one association to ResultadoEvaluacion
    @OneToMany(mappedBy="evaluacionDocente")
    private List<ResultadoEvaluacion> resultadoEvaluacions;

    public EvaluacionDocente() {
    }

    public int getIdEvaluacion() {
        return this.idEvaluacion;
    }

    public void setIdEvaluacion(int idEvaluacion) {
        this.idEvaluacion = idEvaluacion;
    }

    public String getEvaluacionFrealizada() {
        return this.evaluacionFrealizada;
    }

    public void setEvaluacionFrealizada(String evaluacionFrealizada) {
        this.evaluacionFrealizada = evaluacionFrealizada;
    }

    public List<ConclusionEvaluacion> getConclusionEvaluacions() {
        return this.conclusionEvaluacions;
    }

    public void setConclusionEvaluacions(List<ConclusionEvaluacion> conclusionEvaluacions) {
        this.conclusionEvaluacions = conclusionEvaluacions;
    }

    public ConclusionEvaluacion addConclusionEvaluacion(ConclusionEvaluacion conclusionEvaluacion) {
        getConclusionEvaluacions().add(conclusionEvaluacion);
        conclusionEvaluacion.setEvaluacionDocente(this);

        return conclusionEvaluacion;
    }

    public ConclusionEvaluacion removeConclusionEvaluacion(ConclusionEvaluacion conclusionEvaluacion) {
        getConclusionEvaluacions().remove(conclusionEvaluacion);
        conclusionEvaluacion.setEvaluacionDocente(null);

        return conclusionEvaluacion;
    }

    public AreaHasDocente getAreaHasDocente() {
        return this.areaHasDocente;
    }

    public void setAreaHasDocente(AreaHasDocente areaHasDocente) {
        this.areaHasDocente = areaHasDocente;
    }

    public Evaluador getEvaluador() {
        return this.evaluador;
    }

    public void setEvaluador(Evaluador evaluador) {
        this.evaluador = evaluador;
    }

    public FormatoFichaEvaluacion getFormatoFichaEvaluacion() {
        return this.formatoFichaEvaluacion;
    }

    public void setFormatoFichaEvaluacion(FormatoFichaEvaluacion formatoFichaEvaluacion) {
        this.formatoFichaEvaluacion = formatoFichaEvaluacion;
    }

    public List<ResultadoEvaluacion> getResultadoEvaluacions() {
        return this.resultadoEvaluacions;
    }

    public void setResultadoEvaluacions(List<ResultadoEvaluacion> resultadoEvaluacions) {
        this.resultadoEvaluacions = resultadoEvaluacions;
    }

    public ResultadoEvaluacion addResultadoEvaluacion(ResultadoEvaluacion resultadoEvaluacion) {
        getResultadoEvaluacions().add(resultadoEvaluacion);
        resultadoEvaluacion.setEvaluacionDocente(this);

        return resultadoEvaluacion;
    }

    public ResultadoEvaluacion removeResultadoEvaluacion(ResultadoEvaluacion resultadoEvaluacion) {
        getResultadoEvaluacions().remove(resultadoEvaluacion);
        resultadoEvaluacion.setEvaluacionDocente(null);

        return resultadoEvaluacion;
    }

}