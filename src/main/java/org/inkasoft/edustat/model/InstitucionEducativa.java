package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="intitucion_educativa")
@NamedQuery(name="InstitucionEducativa.findAll", query="SELECT i FROM InstitucionEducativa i")
public class InstitucionEducativa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_ie")
	private Integer idInstitucionEducativa;
	@Column(name="ie_codigo")
	private String InstitucionEducativaCodigo;
	@Column(name="ie_nombre")
	private String InstitucionEducativaNombre;
	
	public Integer getIdInstitucionEducativa() {
		return idInstitucionEducativa;
	}
	public void setIdInstitucionEducativa(Integer idInstitucionEducativa) {
		this.idInstitucionEducativa = idInstitucionEducativa;
	}
	public String getInstitucionEducativaCodigo() {
		return InstitucionEducativaCodigo;
	}
	public void setInstitucionEducativaCodigo(String institucionEducativaCodigo) {
		InstitucionEducativaCodigo = institucionEducativaCodigo;
	}
	public String getInstitucionEducativaNombre() {
		return InstitucionEducativaNombre;
	}
	public void setInstitucionEducativaNombre(String institucionEducativaNombre) {
		InstitucionEducativaNombre = institucionEducativaNombre;
	}
}
