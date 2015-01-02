package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nivel database table.
 * 
 */
@Entity
@Table(name="nivel")
@NamedQuery(name="Nivel.findAll", query="SELECT n FROM Nivel n")
public class Nivel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_nivel")
    private int idNivel;

    @Column(name="nivel_nombre")
    private String nivelNombre;

    //bi-directional many-to-one association to Grado
    @OneToMany(mappedBy="nivel")
    private List<Grado> grados;

    public Nivel() {
    }

    public int getIdNivel() {
        return this.idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getNivelNombre() {
        return this.nivelNombre;
    }

    public void setNivelNombre(String nivelNombre) {
        this.nivelNombre = nivelNombre;
    }

    public List<Grado> getGrados() {
        return this.grados;
    }

    public void setGrados(List<Grado> grados) {
        this.grados = grados;
    }

    public Grado addGrado(Grado grado) {
        getGrados().add(grado);
        grado.setNivel(this);

        return grado;
    }

    public Grado removeGrado(Grado grado) {
        getGrados().remove(grado);
        grado.setNivel(null);

        return grado;
    }

}