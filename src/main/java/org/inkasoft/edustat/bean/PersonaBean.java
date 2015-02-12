package org.inkasoft.edustat.bean;

import java.io.Serializable;

import org.inkasoft.edustat.model.Persona;


public class PersonaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private String personaDni;

    private String personaAmaterno;

    private String personaApaterno;

    private String personaPnombre;

    private String personaSnombre;
    
    public PersonaBean () {
    }
    
    public PersonaBean (String personaDni) {
        this.personaDni = personaDni;
    }

    public String getPersonaDni() {
        return personaDni;
    }

    public void setPersonaDni(String personaDni) {
        this.personaDni = personaDni;
    }

    public String getPersonaAmaterno() {
        return personaAmaterno;
    }

    public void setPersonaAmaterno(String personaAmaterno) {
        this.personaAmaterno = personaAmaterno;
    }

    public String getPersonaApaterno() {
        return personaApaterno;
    }

    public void setPersonaApaterno(String personaApaterno) {
        this.personaApaterno = personaApaterno;
    }

    public String getPersonaPnombre() {
        return personaPnombre;
    }

    public void setPersonaPnombre(String personaPnombre) {
        this.personaPnombre = personaPnombre;
    }

    public String getPersonaSnombre() {
        return personaSnombre;
    }

    public void setPersonaSnombre(String personaSnombre) {
        this.personaSnombre = personaSnombre;
    }
    
    public static PersonaBean transformToBean (Persona persona) {
        if (persona == null) {
            return null;
        }
        
        PersonaBean personaBean;
        
        personaBean = new PersonaBean(persona.getPersonaDni());
        
        personaBean.setPersonaAmaterno(persona.getPersonaAmaterno());
        personaBean.setPersonaApaterno(persona.getPersonaApaterno());
        personaBean.setPersonaPnombre(persona.getPersonaPnombre());
        personaBean.setPersonaSnombre(persona.getPersonaSnombre());
        
        return personaBean;
    }
}
