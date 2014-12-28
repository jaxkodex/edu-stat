package org.inkasoft.edustat.bean;

import java.io.Serializable;
import java.util.List;

import org.inkasoft.edustat.model.Grado;

public class GradoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idGrado;
	
	private String gradoNombre;
	
	private List<SeccionBean> secciones;
	
	private List<AreaBean> areas;

	public int getIdGrado() {
		return idGrado;
	}

	public void setIdGrado(int idGrado) {
		this.idGrado = idGrado;
	}

	public String getGradoNombre() {
		return gradoNombre;
	}

	public void setGradoNombre(String gradoNombre) {
		this.gradoNombre = gradoNombre;
	}

	public List<SeccionBean> getSecciones() {
		return secciones;
	}

	public void setSecciones(List<SeccionBean> secciones) {
		this.secciones = secciones;
	}

	public List<AreaBean> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaBean> areas) {
		this.areas = areas;
	}
	
	public static GradoBean transformToBean (Grado grado) {
		if (grado == null) return null;
		GradoBean gradoBean;
		gradoBean = new GradoBean();
		gradoBean.setIdGrado(grado.getIdGrado());
		gradoBean.setGradoNombre(grado.getGradoNombre());
		return gradoBean;
	}

}
