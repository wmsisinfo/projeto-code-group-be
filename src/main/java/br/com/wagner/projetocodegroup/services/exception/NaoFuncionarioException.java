package br.com.wagner.projetocodegroup.services.exception;

public class NaoFuncionarioException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NaoFuncionarioException(String msg) {
        super(msg);
    }

    public NaoFuncionarioException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
