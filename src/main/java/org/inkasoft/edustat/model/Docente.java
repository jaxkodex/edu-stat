package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the docente database table.
 * 
 */
@Entity
@Table(name="docente")
@NamedQuery(name="Docente.findAll", query="SELECT d FROM Docente d")
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_docente")
    private int idDocente;

    //bi-directional many-to-one association to AreaHasDocente
    @OneToMany(mappedBy="docente")
    private List<AreaHasDocente> areaHasDocentes;

    //bi-directional many-to-one association to Persona
    @ManyToOne
    private Persona persona;

    //bi-directional many-to-one association to Evaluador
    @OneToMany(mappedBy="docente")
    private List<Evaluador> evaluadors;

    //bi-directional many-to-one association to InstitucionEducativaHasDocente
    @OneToMany(mappedBy="docente")
    private List<InstitucionEducativaHasDocente> institucionEducativaHasDocentes;

    public Docente() {
    }

    public int getIdDocente() {
        return this.idDocente;
    }

    public void setIdDocente(int idDocente) {
        this.idDocente = idDocente;
    }

    public List<AreaHasDocente> getAreaHasDocentes() {
        return this.areaHasDocentes;
    }

    public void setAreaHasDocentes(List<AreaHasDocente> areaHasDocentes) {
        this.areaHasDocentes = areaHasDocentes;
    }

    public AreaHasDocente addAreaHasDocente(AreaHasDocente areaHasDocente) {
        getAreaHasDocentes().add(areaHasDocente);
        areaHasDocente.setDocente(this);

        return areaHasDocente;
    }

    public AreaHasDocente removeAreaHasDocente(AreaHasDocente areaHasDocente) {
        getAreaHasDocentes().remove(areaHasDocente);
        areaHasDocente.setDocente(null);

        return areaHasDocente;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Evaluador> getEvaluadors() {
        return this.evaluadors;
    }

    public void setEvaluadors(List<Evaluador> evaluadors) {
        this.evaluadors = evaluadors;
    }

    public Evaluador addEvaluador(Evaluador evaluador) {
        getEvaluadors().add(evaluador);
        evaluador.setDocente(this);

        return evaluador;
    }

    public Evaluador removeEvaluador(Evaluador evaluador) {
        getEvaluadors().remove(evaluador);
        evaluador.setDocente(null);

        return evaluador;
    }

    public List<InstitucionEducativaHasDocente> getInstitucionEducativaHasDocentes() {
        return this.institucionEducativaHasDocentes;
    }

    public void setInstitucionEducativaHasDocentes(List<InstitucionEducativaHasDocente> institucionEducativaHasDocentes) {
        this.institucionEducativaHasDocentes = institucionEducativaHasDocentes;
    }

    public InstitucionEducativaHasDocente addInstitucionEducativaHasDocente(InstitucionEducativaHasDocente institucionEducativaHasDocente) {
        getInstitucionEducativaHasDocentes().add(institucionEducativaHasDocente);
        institucionEducativaHasDocente.setDocente(this);

        return institucionEducativaHasDocente;
    }

    public InstitucionEducativaHasDocente removeInstitucionEducativaHasDocente(InstitucionEducativaHasDocente institucionEducativaHasDocente) {
        getInstitucionEducativaHasDocentes().remove(institucionEducativaHasDocente);
        institucionEducativaHasDocente.setDocente(null);

        return institucionEducativaHasDocente;
    }

}