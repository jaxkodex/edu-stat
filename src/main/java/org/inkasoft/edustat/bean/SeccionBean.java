package org.inkasoft.edustat.bean;

import java.io.Serializable;

import org.inkasoft.edustat.model.Seccion;

public class SeccionBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer idSeccion;

    private String seccionNombre;
    
    private GradoBean grado;

    public Integer getIdSeccion() {
        return idSeccion;
    }

    public void setIdSeccion(Integer idSeccion) {
        this.idSeccion = idSeccion;
    }

    public String getSeccionNombre() {
        return seccionNombre;
    }

    public void setSeccionNombre(String seccionNombre) {
        this.seccionNombre = seccionNombre;
    }

    public GradoBean getGrado() {
        return grado;
    }

    public void setGrado(GradoBean grado) {
        this.grado = grado;
    }
    
    public static SeccionBean transformToBean (Seccion seccion) {
        if (seccion == null) {
            return null;
        }
        SeccionBean seccionBean;
        
        seccionBean = new SeccionBean ();
        
        seccionBean.setIdSeccion(seccion.getIdSeccion());
        seccionBean.setSeccionNombre(seccion.getSeccionNombre());
        return seccionBean;
    }
}
