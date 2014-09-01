package org.inkasoft.edustat.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT i FROM Persona i")
public class Persona implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="persona_dni")
	private String dni;
	@Column(name="persona_pnombre")
	private String primerNombre;
	@Column(name="persona_snombre")
	private String segundoNombre;
	@Column(name="persona_apaterno")
	private String apellidoPaterno;
	@Column(name="persona_amaterno")
	private String apellidoMaterno;

	public String getprimerNombre() {
		return primerNombre;
	}
	public void setprimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}
	public String getSegundoNombre() {
		return segundoNombre;
	}
	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
}
