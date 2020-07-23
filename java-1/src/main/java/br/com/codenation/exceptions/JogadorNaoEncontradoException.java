package br.com.codenation.exceptions;

public class JogadorNaoEncontradoException extends RuntimeException{
    private static final long serialVersionUID = -3544451725858932368L;

    public JogadorNaoEncontradoException() {
    }

    public JogadorNaoEncontradoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public JogadorNaoEncontradoException(String message, Throwable cause) {
        super(message, cause);
    }

    public JogadorNaoEncontradoException(String message) {
        super(message);
    }

    public JogadorNaoEncontradoException(Throwable cause) {
        super(cause);
    }
}
