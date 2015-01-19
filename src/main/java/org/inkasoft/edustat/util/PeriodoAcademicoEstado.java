package org.inkasoft.edustat.util;

public enum PeriodoAcademicoEstado {
    PERIODO_ABIERTO("A", "Periodo Abierto"),
    PERIODO_CERRADO("C", "Periodo Cerrado");
    
    private final String codEstado, nomEstado;
    
    PeriodoAcademicoEstado (String codEstado, String nomEstado) {
        this.codEstado = codEstado;
        this.nomEstado = nomEstado;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public String getNomEstado() {
        return nomEstado;
    }

}
