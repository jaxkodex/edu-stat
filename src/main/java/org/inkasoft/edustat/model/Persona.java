package org.inkasoft.edustat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="persona")
@NamedQuery(name="Persona.findAll", query="SELECT i FROM Persona i")
public class Persona {
	@Id
	@GeneratedValue
	@Column(name="id_persona")
	private Integer idPersona;
	@Column(name="persona_pnombre")
	private String primerNombre;
	@Column(name="persona_snombre")
	private String segundoNombre;
	@Column(name="persona_apaterno")
	private String apellidoPaterno;
	@Column(name="persona_amaterno")
	private String apellidoMaterno;
	@Column(name="persona_dni")
	private String dni;
	
	public Integer getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Integer idPersona) {
		this.idPersona = idPersona;
	}
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
