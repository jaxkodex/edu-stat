package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the area database table.
 * 
 */
@Entity
@Table(name="area")
@NamedQuery(name="Area.findAll", query="SELECT a FROM Area a")
public class Area implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_area")
	private int idArea;

	@Column(name="area_nombre")
	private String areaNombre;

	//bi-directional many-to-one association to Grado
	@ManyToOne
	private Grado grado;

	//bi-directional many-to-one association to AreaHasDocente
	@OneToMany(mappedBy="area")
	private List<AreaHasDocente> areaHasDocentes;

	public Area() {
	}

	public int getIdArea() {
		return this.idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	public String getAreaNombre() {
		return this.areaNombre;
	}

	public void setAreaNombre(String areaNombre) {
		this.areaNombre = areaNombre;
	}

	public Grado getGrado() {
		return this.grado;
	}

	public void setGrado(Grado grado) {
		this.grado = grado;
	}

	public List<AreaHasDocente> getAreaHasDocentes() {
		return this.areaHasDocentes;
	}

	public void setAreaHasDocentes(List<AreaHasDocente> areaHasDocentes) {
		this.areaHasDocentes = areaHasDocentes;
	}

	public AreaHasDocente addAreaHasDocente(AreaHasDocente areaHasDocente) {
		getAreaHasDocentes().add(areaHasDocente);
		areaHasDocente.setArea(this);

		return areaHasDocente;
	}

	public AreaHasDocente removeAreaHasDocente(AreaHasDocente areaHasDocente) {
		getAreaHasDocentes().remove(areaHasDocente);
		areaHasDocente.setArea(null);

		return areaHasDocente;
	}

}