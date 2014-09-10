package org.inkasoft.edustat.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="rol")
@NamedQuery(name="Rol.findAll", query="SELECT u FROM Rol u")
public class Rol implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_rol")
	private Integer idRol;
	@Column(name="rol_name")
	private String rolName;
	
	/**
	 * @return the idRol
	 */
	public Integer getIdRol() {
		return idRol;
	}
	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	/**
	 * @return the rolName
	 */
	public String getRolName() {
		return rolName;
	}
	/**
	 * @param rolName the rolName to set
	 */
	public void setRolName(String rolName) {
		this.rolName = rolName;
	}
}
