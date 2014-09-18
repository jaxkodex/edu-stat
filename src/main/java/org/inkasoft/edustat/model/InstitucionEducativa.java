package org.inkasoft.edustat.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the institucion_educativa database table.
 * 
 */
@Entity
@Table(name="institucion_educativa")
@NamedQuery(name="InstitucionEducativa.findAll", query="SELECT i FROM InstitucionEducativa i")
public class InstitucionEducativa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_ie")
	private int idIe;

	@Column(name="ie_codigo")
	private String ieCodigo;

	@Column(name="ie_nombre")
	private String ieNombre;

	//bi-directional many-to-one association to InstitucionEducativaHasDocente
	/*
	@OneToMany(mappedBy="institucionEducativa")
	private List<InstitucionEducativaHasDocente> institucionEducativaHasDocentes;*/

	//bi-directional many-to-one association to PeriodoAcademico
	@JsonIgnore
	@OneToMany(mappedBy="institucionEducativa")
	private List<PeriodoAcademico> periodoAcademicos;

	//bi-directional many-to-one association to Usuario
	@JsonIgnore
	@OneToMany(mappedBy="institucionEducativa")
	private List<Usuario> usuarios;

	public InstitucionEducativa() {
	}

	public int getIdIe() {
		return this.idIe;
	}

	public void setIdIe(int idIe) {
		this.idIe = idIe;
	}

	public String getIeCodigo() {
		return this.ieCodigo;
	}

	public void setIeCodigo(String ieCodigo) {
		this.ieCodigo = ieCodigo;
	}

	public String getIeNombre() {
		return this.ieNombre;
	}

	public void setIeNombre(String ieNombre) {
		this.ieNombre = ieNombre;
	}

	/*public List<InstitucionEducativaHasDocente> getInstitucionEducativaHasDocentes() {
		return this.institucionEducativaHasDocentes;
	}

	public void setInstitucionEducativaHasDocentes(List<InstitucionEducativaHasDocente> institucionEducativaHasDocentes) {
		this.institucionEducativaHasDocentes = institucionEducativaHasDocentes;
	}

	public InstitucionEducativaHasDocente addInstitucionEducativaHasDocente(InstitucionEducativaHasDocente institucionEducativaHasDocente) {
		getInstitucionEducativaHasDocentes().add(institucionEducativaHasDocente);
		institucionEducativaHasDocente.setInstitucionEducativa(this);

		return institucionEducativaHasDocente;
	}

	public InstitucionEducativaHasDocente removeInstitucionEducativaHasDocente(InstitucionEducativaHasDocente institucionEducativaHasDocente) {
		getInstitucionEducativaHasDocentes().remove(institucionEducativaHasDocente);
		institucionEducativaHasDocente.setInstitucionEducativa(null);

		return institucionEducativaHasDocente;
	}*/

	public List<PeriodoAcademico> getPeriodoAcademicos() {
		return this.periodoAcademicos;
	}

	public void setPeriodoAcademicos(List<PeriodoAcademico> periodoAcademicos) {
		this.periodoAcademicos = periodoAcademicos;
	}

	public PeriodoAcademico addPeriodoAcademico(PeriodoAcademico periodoAcademico) {
		getPeriodoAcademicos().add(periodoAcademico);
		periodoAcademico.setInstitucionEducativa(this);

		return periodoAcademico;
	}

	public PeriodoAcademico removePeriodoAcademico(PeriodoAcademico periodoAcademico) {
		getPeriodoAcademicos().remove(periodoAcademico);
		periodoAcademico.setInstitucionEducativa(null);

		return periodoAcademico;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setInstitucionEducativa(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setInstitucionEducativa(null);

		return usuario;
	}

}