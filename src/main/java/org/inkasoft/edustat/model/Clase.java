package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clase database table.
 * 
 */
@Entity
@Table(name="clase")
@NamedQuery(name="Clase.findAll", query="SELECT c FROM Clase c")
public class Clase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_clase")
    private int idClase;
    
    private boolean habilitado;

    //bi-directional many-to-one association to AreaHasDocente
    @OneToMany(mappedBy="clase")
    private List<AreaHasDocente> areaHasDocentes;

    //bi-directional many-to-one association to PeriodoAcademico
    @ManyToOne
    @JoinColumn(name="periodo_academico_id_periodo")
    private PeriodoAcademico periodoAcademico;

    //bi-directional many-to-one association to Seccion
    @ManyToOne
    private Seccion seccion;

    //bi-directional many-to-one association to Turno
    @ManyToOne
    private Turno turno;

    public Clase() {
    }

    public int getIdClase() {
        return this.idClase;
    }

    public void setIdClase(int idClase) {
        this.idClase = idClase;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public List<AreaHasDocente> getAreaHasDocentes() {
        return this.areaHasDocentes;
    }

    public void setAreaHasDocentes(List<AreaHasDocente> areaHasDocentes) {
        this.areaHasDocentes = areaHasDocentes;
    }

    public AreaHasDocente addAreaHasDocente(AreaHasDocente areaHasDocente) {
        getAreaHasDocentes().add(areaHasDocente);
        areaHasDocente.setClase(this);

        return areaHasDocente;
    }

    public AreaHasDocente removeAreaHasDocente(AreaHasDocente areaHasDocente) {
        getAreaHasDocentes().remove(areaHasDocente);
        areaHasDocente.setClase(null);

        return areaHasDocente;
    }

    public PeriodoAcademico getPeriodoAcademico() {
        return this.periodoAcademico;
    }

    public void setPeriodoAcademico(PeriodoAcademico periodoAcademico) {
        this.periodoAcademico = periodoAcademico;
    }

    public Seccion getSeccion() {
        return this.seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Turno getTurno() {
        return this.turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

}