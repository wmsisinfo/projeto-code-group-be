package br.com.wagner.projetocodegroup.services.exception;

public class DeleteProjetoForbidenException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DeleteProjetoForbidenException(String msg) {
        super(msg);
    }

    public DeleteProjetoForbidenException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
