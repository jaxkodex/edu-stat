package org.inkasoft.edustat.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private String username;

//    @JsonIgnore
    private String password;

    //bi-directional many-to-one association to InstitucionEducativa
    @ManyToOne
    @JoinColumn(name="institucion_educativa_id_ie")
    private InstitucionEducativa institucionEducativa;

    //bi-directional many-to-one association to Persona
    @ManyToOne
    private Persona persona;

    //bi-directional many-to-many association to Rol
    //@ManyToMany(mappedBy="usuarios", fetch=FetchType.EAGER)
    @JsonIgnore
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinTable(
        name="usuario_has_rol"
        , joinColumns={
            @JoinColumn(name="usuario_username", referencedColumnName="username")
            }
        , inverseJoinColumns={
            @JoinColumn(name="rol_id_rol", referencedColumnName="id_rol")
            }
        )
    private List<Rol> rols;

    public Usuario() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonIgnore
    public String getPassword() {
        return this.password;
    }

    @JsonProperty
    public void setPassword(String password) {
        this.password = password;
    }

    public InstitucionEducativa getInstitucionEducativa() {
        return this.institucionEducativa;
    }

    public void setInstitucionEducativa(InstitucionEducativa institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }

    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Rol> getRols() {
        if (this.rols == null) {
            this.rols = new ArrayList<Rol>();
        }
        return this.rols;
    }

    @JsonProperty
    public void setRols(List<Rol> rols) {
        this.rols = rols;
    }

}