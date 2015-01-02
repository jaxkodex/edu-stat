package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the seccion database table.
 * 
 */
@Entity
@Table(name = "seccion")
@NamedQuery(name = "Seccion.findAll", query = "SELECT s FROM Seccion s")
public class Seccion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_seccion")
    private int idSeccion;

    @Column(name = "seccion_nombre")
    private String seccionNombre;

    // bi-directional many-to-one association to Clase
    @OneToMany(mappedBy = "seccion")
    private List<Clase> clases;

    // bi-directional many-to-one association to Grado
    @ManyToOne
    private Grado grado;

    public Seccion() {
    }

    public int getIdSeccion() {
        return this.idSeccion;
    }

    public void setIdSeccion(int idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getSeccionNombre() {
        return this.seccionNombre;
    }

    public void setSeccionNombre(String seccionNombre) {
        this.seccionNombre = seccionNombre;
    }

    public List<Clase> getClases() {
        return this.clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }

    public Clase addClas(Clase clas) {
        getClases().add(clas);
        clas.setSeccion(this);

        return clas;
    }

    public Clase removeClas(Clase clas) {
        getClases().remove(clas);
        clas.setSeccion(null);

        return clas;
    }

    public Grado getGrado() {
        return this.grado;
    }

    public void setGrado(Grado grado) {
        this.grado = grado;
    }

}