package org.inkasoft.edustat.util.exceptions;

public class ApiControllerException extends Exception {
    private static final long serialVersionUID = 1L;

    public ApiControllerException (String mensaje, Throwable ex) {
        super(mensaje, ex);
    }

}
