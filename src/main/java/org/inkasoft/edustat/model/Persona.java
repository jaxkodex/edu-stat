package org.inkasoft.edustat.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the persona database table.
 * 
 */
@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT p FROM Persona p")
public class Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="persona_dni")
    private String personaDni;

    @Column(name="persona_amaterno")
    private String personaAmaterno;

    @Column(name="persona_apaterno")
    private String personaApaterno;

    @Column(name="persona_pnombre")
    private String personaPnombre;

    @Column(name="persona_snombre")
    private String personaSnombre;

    //bi-directional many-to-one association to Docente
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Docente> docentes;

    //bi-directional many-to-one association to Usuario
    @JsonIgnore
    @OneToMany(mappedBy="persona")
    private List<Usuario> usuarios;

    public Persona() {
    }

    public String getPersonaDni() {
        return this.personaDni;
    }

    public void setPersonaDni(String personaDni) {
        this.personaDni = personaDni;
    }

    public String getPersonaAmaterno() {
        return this.personaAmaterno;
    }

    public void setPersonaAmaterno(String personaAmaterno) {
        this.personaAmaterno = personaAmaterno;
    }

    public String getPersonaApaterno() {
        return this.personaApaterno;
    }

    public void setPersonaApaterno(String personaApaterno) {
        this.personaApaterno = personaApaterno;
    }

    public String getPersonaPnombre() {
        return this.personaPnombre;
    }

    public void setPersonaPnombre(String personaPnombre) {
        this.personaPnombre = personaPnombre;
    }

    public String getPersonaSnombre() {
        return this.personaSnombre;
    }

    public void setPersonaSnombre(String personaSnombre) {
        this.personaSnombre = personaSnombre;
    }

    public List<Docente> getDocentes() {
        return this.docentes;
    }

    public void setDocentes(List<Docente> docentes) {
        this.docentes = docentes;
    }

    public Docente addDocente(Docente docente) {
        getDocentes().add(docente);
        docente.setPersona(this);

        return docente;
    }

    public Docente removeDocente(Docente docente) {
        getDocentes().remove(docente);
        docente.setPersona(null);

        return docente;
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario addUsuario(Usuario usuario) {
        getUsuarios().add(usuario);
        usuario.setPersona(this);

        return usuario;
    }

    public Usuario removeUsuario(Usuario usuario) {
        getUsuarios().remove(usuario);
        usuario.setPersona(null);

        return usuario;
    }

}