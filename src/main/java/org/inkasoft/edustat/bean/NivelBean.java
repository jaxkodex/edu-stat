package org.inkasoft.edustat.bean;

import java.io.Serializable;
import java.util.List;

import org.inkasoft.edustat.model.Nivel;

public class NivelBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idNivel;
    
    private String nivelNombre;
    
    private List<GradoBean> grados;

    public int getIdNivel() {
        return idNivel;
    }

    public void setIdNivel(int idNivel) {
        this.idNivel = idNivel;
    }

    public String getNivelNombre() {
        return nivelNombre;
    }

    public void setNivelNombre(String nivelNombre) {
        this.nivelNombre = nivelNombre;
    }

    public List<GradoBean> getGrados() {
        return grados;
    }

    public void setGrados(List<GradoBean> grados) {
        this.grados = grados;
    }
    
    public static NivelBean transformToBean (Nivel nivel) {
        if (nivel == null) {
            return null;
        }
        NivelBean nivelBean;
        
        nivelBean = new NivelBean();
        
        nivelBean.setIdNivel(nivel.getIdNivel());
        nivelBean.setNivelNombre(nivel.getNivelNombre());
        return nivelBean;
    }

}
