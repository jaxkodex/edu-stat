package org.inkasoft.edustat.bean;

import java.io.Serializable;

import org.inkasoft.edustat.model.Docente;

public class DocenteBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idDocente;
    private PersonaBean persona;
    
    public DocenteBean () {
    }
    
    public DocenteBean (Integer idDocente) {
        this.idDocente = idDocente;
    }

    public Integer getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(Integer idDocente) {
        this.idDocente = idDocente;
    }

    public PersonaBean getPersona() {
        return persona;
    }

    public void setPersona(PersonaBean persona) {
        this.persona = persona;
    }
    
    public static DocenteBean transformToBean (Docente docente) {
        if (docente == null) {
            return null;
        }
        return new DocenteBean (docente.getIdDocente());
    }

}
