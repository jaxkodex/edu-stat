package org.inkasoft.edustat.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the monitoreo database table.
 * 
 */
@Entity
@Table(name="monitoreo")
@NamedQuery(name="Monitoreo.findAll", query="SELECT m FROM Monitoreo m")
public class Monitoreo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_monitoreo")
	private int idMonitoreo;

	@Column(name="monitoreo_estado")
	private byte monitoreoEstado;

	@Temporal(TemporalType.DATE)
	@Column(name="monitoreo_ffin")
	private Date monitoreoFfin;

	@Temporal(TemporalType.DATE)
	@Column(name="monitoreo_finicio")
	private Date monitoreoFinicio;

	//bi-directional many-to-one association to Evaluador
	@OneToMany(mappedBy="monitoreo")
	private List<Evaluador> evaluadors;

	public Monitoreo() {
	}

	public int getIdMonitoreo() {
		return this.idMonitoreo;
	}

	public void setIdMonitoreo(int idMonitoreo) {
		this.idMonitoreo = idMonitoreo;
	}

	public byte getMonitoreoEstado() {
		return this.monitoreoEstado;
	}

	public void setMonitoreoEstado(byte monitoreoEstado) {
		this.monitoreoEstado = monitoreoEstado;
	}

	public Date getMonitoreoFfin() {
		return this.monitoreoFfin;
	}

	public void setMonitoreoFfin(Date monitoreoFfin) {
		this.monitoreoFfin = monitoreoFfin;
	}

	public Date getMonitoreoFinicio() {
		return this.monitoreoFinicio;
	}

	public void setMonitoreoFinicio(Date monitoreoFinicio) {
		this.monitoreoFinicio = monitoreoFinicio;
	}

	public List<Evaluador> getEvaluadors() {
		return this.evaluadors;
	}

	public void setEvaluadors(List<Evaluador> evaluadors) {
		this.evaluadors = evaluadors;
	}

	public Evaluador addEvaluador(Evaluador evaluador) {
		getEvaluadors().add(evaluador);
		evaluador.setMonitoreo(this);

		return evaluador;
	}

	public Evaluador removeEvaluador(Evaluador evaluador) {
		getEvaluadors().remove(evaluador);
		evaluador.setMonitoreo(null);

		return evaluador;
	}

}