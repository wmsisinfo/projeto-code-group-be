package br.com.wagner.projetocodegroup.services.exception;

public class RiscoInvalidoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RiscoInvalidoException(String msg) {
        super(msg);
    }

    public RiscoInvalidoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
