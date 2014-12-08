package org.inkasoft.edustat.bean;

import java.io.Serializable;

public class DocenteBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer idDocente;
	
	private PersonaBean persona;

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

}
