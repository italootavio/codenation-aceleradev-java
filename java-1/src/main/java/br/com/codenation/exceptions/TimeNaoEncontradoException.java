package br.com.codenation.exceptions;

public class TimeNaoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = -3544451725858932368L;

    public TimeNaoEncontradoException() {
    }

    public TimeNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TimeNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public TimeNaoEncontradoException(String message) {
        super(message);
    }

    public TimeNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}
