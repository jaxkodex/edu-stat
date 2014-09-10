package org.inkasoft.edustat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	private String username;
	private String password;
	
	@ManyToOne
	@JoinColumn(name="persona_persona_dni")
	private Persona persona;
	
	@ManyToOne
	@JoinColumn(name="institucion_educativa_id_ie")
	private InstitucionEducativa institucionEducativa;
	
	@JsonIgnore
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_has_rol", 
			joinColumns = @JoinColumn(name="usuario_username", referencedColumnName="username"),
			inverseJoinColumns = @JoinColumn(name="rol_id_rol", referencedColumnName="id_rol")
	)
	private List<Rol> roles;
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@JsonIgnore
	public String getPassword() {
		return password;
	}
	@JsonProperty(value="password")
	public void setPassword(String password) {
		this.password = password;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	public InstitucionEducativa getInstitucionEducativa() {
		return institucionEducativa;
	}
	public void setInstitucionEducativa(InstitucionEducativa institucionEducativa) {
		this.institucionEducativa = institucionEducativa;
	}
	/**
	 * @return the roles
	 */
	public List<Rol> getRoles() {
		return roles;
	}
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}
}
