package br.com.wagner.projetocodegroup.services.exception;

public class StatusProjetoInvalidoException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public StatusProjetoInvalidoException(String msg) {
        super(msg);
    }

    public StatusProjetoInvalidoException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
