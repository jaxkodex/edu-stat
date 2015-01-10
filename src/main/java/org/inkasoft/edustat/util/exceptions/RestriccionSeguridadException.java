package org.inkasoft.edustat.util.exceptions;

public class RestriccionSeguridadException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public RestriccionSeguridadException (String mensaje) {
        super(mensaje);
    }

}
