package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
@Table(name = "turno")
@NamedQuery(name = "Turno.findAll", query = "SELECT t FROM Turno t")
public class Turno implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_turno")
    private int idTurno;

    @Column(name = "turno_name")
    private String turnoName;

    // bi-directional many-to-one association to Clase
    @OneToMany(mappedBy = "turno")
    private List<Clase> clases;

    public Turno() {
    }

    public int getIdTurno() {
        return this.idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public String getTurnoName() {
        return this.turnoName;
    }

    public void setTurnoName(String turnoName) {
        this.turnoName = turnoName;
    }

    public List<Clase> getClases() {
        return this.clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public Clase addClas(Clase clas) {
        getClases().add(clas);
        clas.setTurno(this);

        return clas;
    }

    public Clase removeClas(Clase clas) {
        getClases().remove(clas);
        clas.setTurno(null);

        return clas;
    }

}