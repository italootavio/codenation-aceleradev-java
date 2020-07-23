package br.com.codenation.exceptions;

public class IdentificadorUtilizadoException extends RuntimeException{
    private static final long serialVersionUID = -3544451725858932368L;

    public IdentificadorUtilizadoException() {
    }

    public IdentificadorUtilizadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IdentificadorUtilizadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public IdentificadorUtilizadoException(String message) {
        super(message);
    }

    public IdentificadorUtilizadoException(Throwable cause) {
        super(cause);
    }
}
