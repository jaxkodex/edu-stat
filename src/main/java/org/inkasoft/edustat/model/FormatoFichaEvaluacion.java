package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the formato_ficha_evaluacion database table.
 * 
 */
@Entity
@Table(name="formato_ficha_evaluacion")
@NamedQuery(name="FormatoFichaEvaluacion.findAll", query="SELECT f FROM FormatoFichaEvaluacion f")
public class FormatoFichaEvaluacion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_formato")
    private int idFormato;

    @Column(name="formato_version")
    private String formatoVersion;

    //bi-directional many-to-one association to EvaluacionDocente
    @OneToMany(mappedBy="formatoFichaEvaluacion")
    private List<EvaluacionDocente> evaluacionDocentes;

    //bi-directional many-to-one association to SeccionFormato
    @OneToMany(mappedBy="formatoFichaEvaluacion")
    private List<SeccionFormato> seccionFormatos;

    public FormatoFichaEvaluacion() {
    }

    public int getIdFormato() {
        return this.idFormato;
    }

    public void setIdFormato(int idFormato) {
        this.idFormato = idFormato;
    }

    public String getFormatoVersion() {
        return this.formatoVersion;
    }

    public void setFormatoVersion(String formatoVersion) {
        this.formatoVersion = formatoVersion;
    }

    public List<EvaluacionDocente> getEvaluacionDocentes() {
        return this.evaluacionDocentes;
    }

    public void setEvaluacionDocentes(List<EvaluacionDocente> evaluacionDocentes) {
        this.evaluacionDocentes = evaluacionDocentes;
    }

    public EvaluacionDocente addEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
        getEvaluacionDocentes().add(evaluacionDocente);
        evaluacionDocente.setFormatoFichaEvaluacion(this);

        return evaluacionDocente;
    }

    public EvaluacionDocente removeEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
        getEvaluacionDocentes().remove(evaluacionDocente);
        evaluacionDocente.setFormatoFichaEvaluacion(null);

        return evaluacionDocente;
    }

    public List<SeccionFormato> getSeccionFormatos() {
        return this.seccionFormatos;
    }

    public void setSeccionFormatos(List<SeccionFormato> seccionFormatos) {
        this.seccionFormatos = seccionFormatos;
    }

    public SeccionFormato addSeccionFormato(SeccionFormato seccionFormato) {
        getSeccionFormatos().add(seccionFormato);
        seccionFormato.setFormatoFichaEvaluacion(this);

        return seccionFormato;
    }

    public SeccionFormato removeSeccionFormato(SeccionFormato seccionFormato) {
        getSeccionFormatos().remove(seccionFormato);
        seccionFormato.setFormatoFichaEvaluacion(null);

        return seccionFormato;
    }

}