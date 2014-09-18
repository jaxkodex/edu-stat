package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evaluador database table.
 * 
 */
@Entity
@Table(name="evaluador")
@NamedQuery(name="Evaluador.findAll", query="SELECT e FROM Evaluador e")
public class Evaluador implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_evaluador")
	private int idEvaluador;

	private byte estado;

	//bi-directional many-to-one association to EvaluacionDocente
	@OneToMany(mappedBy="evaluador")
	private List<EvaluacionDocente> evaluacionDocentes;

	//bi-directional many-to-one association to Docente
	@ManyToOne
	private Docente docente;

	//bi-directional many-to-one association to Monitoreo
	@ManyToOne
	private Monitoreo monitoreo;

	public Evaluador() {
	}

	public int getIdEvaluador() {
		return this.idEvaluador;
	}

	public void setIdEvaluador(int idEvaluador) {
		this.idEvaluador = idEvaluador;
	}

	public byte getEstado() {
		return this.estado;
	}

	public void setEstado(byte estado) {
		this.estado = estado;
	}

	public List<EvaluacionDocente> getEvaluacionDocentes() {
		return this.evaluacionDocentes;
	}

	public void setEvaluacionDocentes(List<EvaluacionDocente> evaluacionDocentes) {
		this.evaluacionDocentes = evaluacionDocentes;
	}

	public EvaluacionDocente addEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
		getEvaluacionDocentes().add(evaluacionDocente);
		evaluacionDocente.setEvaluador(this);

		return evaluacionDocente;
	}

	public EvaluacionDocente removeEvaluacionDocente(EvaluacionDocente evaluacionDocente) {
		getEvaluacionDocentes().remove(evaluacionDocente);
		evaluacionDocente.setEvaluador(null);

		return evaluacionDocente;
	}

	public Docente getDocente() {
		return this.docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	public Monitoreo getMonitoreo() {
		return this.monitoreo;
	}

	public void setMonitoreo(Monitoreo monitoreo) {
		this.monitoreo = monitoreo;
	}

}