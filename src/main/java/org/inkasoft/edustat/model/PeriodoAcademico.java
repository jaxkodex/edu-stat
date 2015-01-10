package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the periodo_academico database table.
 * 
 */
@Entity
@Table(name="periodo_academico")
@NamedQuery(name="PeriodoAcademico.findAll", query="SELECT p FROM PeriodoAcademico p")
public class PeriodoAcademico implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_periodo")
    private int idPeriodo;

    @Temporal(TemporalType.DATE)
    @Column(name="periodo_ffin")
    private Date periodoFfin;

    @Temporal(TemporalType.DATE)
    @Column(name="periodo_finicio")
    private Date periodoFinicio;

    @Column(name="periodo_nombre")
    private String periodoNombre;

    //bi-directional many-to-one association to Clase
    @OneToMany(mappedBy="periodoAcademico")
    private List<Clase> clases;

    //bi-directional many-to-one association to InstitucionEducativa
    @ManyToOne
    @JoinColumn(name="institucion_educativa_id_ie")
    private InstitucionEducativa institucionEducativa;

    public PeriodoAcademico() {
    }

    public int getIdPeriodo() {
        return this.idPeriodo;
    }

    public void setIdPeriodo(int idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Date getPeriodoFfin() {
        return this.periodoFfin;
    }

    public void setPeriodoFfin(Date periodoFfin) {
        this.periodoFfin = periodoFfin;
    }

    public Date getPeriodoFinicio() {
        return this.periodoFinicio;
    }

    public void setPeriodoFinicio(Date periodoFinicio) {
        this.periodoFinicio = periodoFinicio;
    }

    public String getPeriodoNombre() {
        return this.periodoNombre;
    }

    public void setPeriodoNombre(String periodoNombre) {
        this.periodoNombre = periodoNombre;
    }

    public List<Clase> getClases() {
        return this.clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public Clase addClas(Clase clas) {
        getClases().add(clas);
        clas.setPeriodoAcademico(this);

        return clas;
    }

    public Clase removeClas(Clase clas) {
        getClases().remove(clas);
        clas.setPeriodoAcademico(null);

        return clas;
    }

    public InstitucionEducativa getInstitucionEducativa() {
        return this.institucionEducativa;
    }

    public void setInstitucionEducativa(InstitucionEducativa institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

}