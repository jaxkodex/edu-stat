package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the seccion_formato database table.
 * 
 */
@Entity
@Table(name="seccion_formato")
@NamedQuery(name="SeccionFormato.findAll", query="SELECT s FROM SeccionFormato s")
public class SeccionFormato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_sformato")
	private int idSformato;

	@Column(name="sformato_name")
	private String sformatoName;

	//bi-directional many-to-one association to CriterioFormato
	@OneToMany(mappedBy="seccionFormato")
	private List<CriterioFormato> criterioFormatos;

	//bi-directional many-to-one association to FormatoFichaEvaluacion
	@ManyToOne
	@JoinColumn(name="formato_ficha_evaluacion_id_formato")
	private FormatoFichaEvaluacion formatoFichaEvaluacion;

	public SeccionFormato() {
	}

	public int getIdSformato() {
		return this.idSformato;
	}

	public void setIdSformato(int idSformato) {
		this.idSformato = idSformato;
	}

	public String getSformatoName() {
		return this.sformatoName;
	}

	public void setSformatoName(String sformatoName) {
		this.sformatoName = sformatoName;
	}

	public List<CriterioFormato> getCriterioFormatos() {
		return this.criterioFormatos;
	}

	public void setCriterioFormatos(List<CriterioFormato> criterioFormatos) {
		this.criterioFormatos = criterioFormatos;
	}

	public CriterioFormato addCriterioFormato(CriterioFormato criterioFormato) {
		getCriterioFormatos().add(criterioFormato);
		criterioFormato.setSeccionFormato(this);

		return criterioFormato;
	}

	public CriterioFormato removeCriterioFormato(CriterioFormato criterioFormato) {
		getCriterioFormatos().remove(criterioFormato);
		criterioFormato.setSeccionFormato(null);

		return criterioFormato;
	}

	public FormatoFichaEvaluacion getFormatoFichaEvaluacion() {
		return this.formatoFichaEvaluacion;
	}

	public void setFormatoFichaEvaluacion(FormatoFichaEvaluacion formatoFichaEvaluacion) {
		this.formatoFichaEvaluacion = formatoFichaEvaluacion;
	}

}