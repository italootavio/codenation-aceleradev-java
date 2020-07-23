package br.com.codenation.exceptions;

public class CapitaoNaoInformadoException extends RuntimeException{
    private static final long serialVersionUID = -3544451725858932368L;

    public CapitaoNaoInformadoException() {
    }

    public CapitaoNaoInformadoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CapitaoNaoInformadoException(String message, Throwable cause) {
        super(message, cause);
    }

    public CapitaoNaoInformadoException(String message) {
        super(message);
    }

    public CapitaoNaoInformadoException(Throwable cause) {
        super(cause);
    }
}
