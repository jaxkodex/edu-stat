package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the opcion_formato database table.
 * 
 */
@Entity
@Table(name="opcion_formato")
@NamedQuery(name="OpcionFormato.findAll", query="SELECT o FROM OpcionFormato o")
public class OpcionFormato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_oformato")
	private int idOformato;

	@Column(name="oformato_name")
	private String oformatoName;

	@Column(name="oformato_valor")
	private int oformatoValor;

	//bi-directional many-to-one association to CriterioFormato
	@ManyToOne
	@JoinColumn(name="criterio_formato_id_cformato")
	private CriterioFormato criterioFormato;

	public OpcionFormato() {
	}

	public int getIdOformato() {
		return this.idOformato;
	}

	public void setIdOformato(int idOformato) {
		this.idOformato = idOformato;
	}

	public String getOformatoName() {
		return this.oformatoName;
	}

	public void setOformatoName(String oformatoName) {
		this.oformatoName = oformatoName;
	}

	public int getOformatoValor() {
		return this.oformatoValor;
	}

	public void setOformatoValor(int oformatoValor) {
		this.oformatoValor = oformatoValor;
	}

	public CriterioFormato getCriterioFormato() {
		return this.criterioFormato;
	}

	public void setCriterioFormato(CriterioFormato criterioFormato) {
		this.criterioFormato = criterioFormato;
	}

}