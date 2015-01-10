package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the institucion_educativa_has_docente database table.
 * 
 */
@Entity
@Table(name="institucion_educativa_has_docente")
@NamedQuery(name="InstitucionEducativaHasDocente.findAll", query="SELECT i FROM InstitucionEducativaHasDocente i")
public class InstitucionEducativaHasDocente implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private InstitucionEducativaHasDocentePK id;

    @Column(name="es_director")
    private byte esDirector;

    //bi-directional many-to-one association to Docente
    @ManyToOne
    @JoinColumn(name="docente_id_docente", insertable=false, updatable=false)
    private Docente docente;

    //bi-directional many-to-one association to InstitucionEducativa
    @ManyToOne
    @JoinColumn(name="institucion_educativa_id_ie", insertable=false, updatable=false)
    private InstitucionEducativa institucionEducativa;

    public InstitucionEducativaHasDocente() {
    }

    public InstitucionEducativaHasDocentePK getId() {
        return this.id;
    }

    public void setId(InstitucionEducativaHasDocentePK id) {
        this.id = id;
    }

    public byte getEsDirector() {
        return this.esDirector;
    }

    public void setEsDirector(byte esDirector) {
        this.esDirector = esDirector;
    }

    public Docente getDocente() {
        return this.docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public InstitucionEducativa getInstitucionEducativa() {
        return this.institucionEducativa;
    }

    public void setInstitucionEducativa(InstitucionEducativa institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

}