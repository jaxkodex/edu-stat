package org.inkasoft.edustat.util.exceptions;

public class PeriodoAcademicoAbiertoYaExisteException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public PeriodoAcademicoAbiertoYaExisteException (String mensaje) {
        super(mensaje);
    }

}
