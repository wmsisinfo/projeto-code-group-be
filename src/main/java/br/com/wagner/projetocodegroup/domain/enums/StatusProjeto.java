package br.com.wagner.projetocodegroup.domain.enums;

import org.springframework.util.StringUtils;

public enum StatusProjeto {

    EM_ANALISE("EM ANALISE"),
    ANALISE_REALIZADA("ANALISE REALIZADA"),
    ANALISE_APROVADA("ANALISE APROVADA"),
    INICIADO("INICIADO"),
    PLANEJADO("PLANEJADO"),
    EM_ANDAMENTO("EM ANDAMENTO"),
    ENCERRADO("ENCERRADO"),
    CANCELADO("CANCELADO");

    private String status;

    StatusProjeto(String status) {
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }

    public static StatusProjeto stringToEnum(String status) {

        if (!StringUtils.hasLength(status)) {
            return null;
        }

        for (StatusProjeto r : StatusProjeto.values()) {
            if (status.equals(r.getStatus())) {
                return r;
            }
        }
        throw new IllegalArgumentException("Tipo inválido:" + status);
    }

    public static StatusProjeto toEnum(String status) {

        if (!StringUtils.hasLength(status)) {
            return null;
        }

        for (StatusProjeto p: StatusProjeto.values()) {
            if (status == p.getStatus()) {
                return p;
            }
        }
        throw new IllegalArgumentException("Status inválido:" + status);
    }

}
