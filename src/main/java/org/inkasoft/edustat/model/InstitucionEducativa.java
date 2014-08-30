package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="institucion_educativa")
@NamedQuery(name="InstitucionEducativa.findAll", query="SELECT i FROM InstitucionEducativa i")
public class InstitucionEducativa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id_ie")
	private Integer idInstitucionEducativa;
	@Column(name="ie_codigo")
	private String institucionEducativaCodigo;
	@Column(name="ie_nombre")
	private String institucionEducativaNombre;
	
	public Integer getIdInstitucionEducativa() {
		return idInstitucionEducativa;
	}
	public void setIdInstitucionEducativa(Integer idInstitucionEducativa) {
		this.idInstitucionEducativa = idInstitucionEducativa;
	}
	public String getInstitucionEducativaCodigo() {
		return institucionEducativaCodigo;
	}
	public void setInstitucionEducativaCodigo(String institucionEducativaCodigo) {
		this.institucionEducativaCodigo = institucionEducativaCodigo;
	}
	public String getInstitucionEducativaNombre() {
		return institucionEducativaNombre;
	}
	public void setInstitucionEducativaNombre(String institucionEducativaNombre) {
		this.institucionEducativaNombre = institucionEducativaNombre;
	}
}
