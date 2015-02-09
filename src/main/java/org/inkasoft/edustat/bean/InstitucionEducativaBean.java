package org.inkasoft.edustat.bean;

import java.io.Serializable;

import org.inkasoft.edustat.model.InstitucionEducativa;

public class InstitucionEducativaBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idIe;

    private String ieCodigo;

    private String ieNombre;

    public int getIdIe() {
        return idIe;
    }

    public void setIdIe(int idIe) {
        this.idIe = idIe;
    }

    public String getIeCodigo() {
        return ieCodigo;
    }

    public void setIeCodigo(String ieCodigo) {
        this.ieCodigo = ieCodigo;
    }

    public String getIeNombre() {
        return ieNombre;
    }

    public void setIeNombre(String ieNombre) {
        this.ieNombre = ieNombre;
    }
    
    public static InstitucionEducativaBean transformToBean (InstitucionEducativa institucionEducativa) {
        InstitucionEducativaBean institucionEducativaBean = new InstitucionEducativaBean();
        
        institucionEducativaBean.setIdIe(institucionEducativa.getIdIe());
        institucionEducativaBean.setIeCodigo(institucionEducativa.getIeCodigo());
        institucionEducativaBean.setIeNombre(institucionEducativa.getIeNombre());
        
        return institucionEducativaBean;
    }
}
