package org.inkasoft.edustat.util.exceptions;

public class UsuarioYaExisteException extends Exception {
    private static final long serialVersionUID = 1L;
    
    public UsuarioYaExisteException (String mensaje) {
        super(mensaje);
    }

}
