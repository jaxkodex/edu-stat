package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the criterio_formato database table.
 * 
 */
@Entity
@Table(name="criterio_formato")
@NamedQuery(name="CriterioFormato.findAll", query="SELECT c FROM CriterioFormato c")
public class CriterioFormato implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_cformato")
    private int idCformato;

    @Column(name="cformato_name")
    private String cformatoName;

    //bi-directional many-to-one association to SeccionFormato
    @ManyToOne
    @JoinColumn(name="seccion_formato_id_sformato")
    private SeccionFormato seccionFormato;

    //bi-directional many-to-one association to OpcionFormato
    @OneToMany(mappedBy="criterioFormato")
    private List<OpcionFormato> opcionFormatos;

    //bi-directional many-to-one association to ResultadoEvaluacion
    @OneToMany(mappedBy="criterioFormato")
    private List<ResultadoEvaluacion> resultadoEvaluacions;

    public CriterioFormato() {
    }

    public int getIdCformato() {
        return this.idCformato;
    }

    public void setIdCformato(int idCformato) {
        this.idCformato = idCformato;
    }

    public String getCformatoName() {
        return this.cformatoName;
    }

    public void setCformatoName(String cformatoName) {
        this.cformatoName = cformatoName;
    }

    public SeccionFormato getSeccionFormato() {
        return this.seccionFormato;
    }

    public void setSeccionFormato(SeccionFormato seccionFormato) {
        this.seccionFormato = seccionFormato;
    }

    public List<OpcionFormato> getOpcionFormatos() {
        return this.opcionFormatos;
    }

    public void setOpcionFormatos(List<OpcionFormato> opcionFormatos) {
        this.opcionFormatos = opcionFormatos;
    }

    public OpcionFormato addOpcionFormato(OpcionFormato opcionFormato) {
        getOpcionFormatos().add(opcionFormato);
        opcionFormato.setCriterioFormato(this);

        return opcionFormato;
    }

    public OpcionFormato removeOpcionFormato(OpcionFormato opcionFormato) {
        getOpcionFormatos().remove(opcionFormato);
        opcionFormato.setCriterioFormato(null);

        return opcionFormato;
    }

    public List<ResultadoEvaluacion> getResultadoEvaluacions() {
        return this.resultadoEvaluacions;
    }

    public void setResultadoEvaluacions(List<ResultadoEvaluacion> resultadoEvaluacions) {
        this.resultadoEvaluacions = resultadoEvaluacions;
    }

    public ResultadoEvaluacion addResultadoEvaluacion(ResultadoEvaluacion resultadoEvaluacion) {
        getResultadoEvaluacions().add(resultadoEvaluacion);
        resultadoEvaluacion.setCriterioFormato(this);

        return resultadoEvaluacion;
    }

    public ResultadoEvaluacion removeResultadoEvaluacion(ResultadoEvaluacion resultadoEvaluacion) {
        getResultadoEvaluacions().remove(resultadoEvaluacion);
        resultadoEvaluacion.setCriterioFormato(null);

        return resultadoEvaluacion;
    }

}