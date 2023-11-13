package br.com.wagner.projetocodegroup.domain.enums;

import br.com.wagner.projetocodegroup.services.exception.RiscoInvalidoException;
import org.springframework.util.StringUtils;

public enum RiscoProjeto {

    BAIXO("BAIXO"),
    MEDIO("MEDIO"),
    ALTO("ALTO");

    RiscoProjeto(String risco) {
        this.risco = risco;
    }

    private String risco;

    public String getRisco() {
        return this.risco;
    }

    public static RiscoProjeto stringToEnum(String risco) {

        if (!StringUtils.hasLength(risco)) {
            return null;
        }

        for (RiscoProjeto r : RiscoProjeto.values()) {
            if (risco.equals(r.getRisco())) {
                return r;
            }
        }
        throw new RiscoInvalidoException("Tipo inválido:" + risco);
    }

    public static RiscoProjeto toEnum(String risco) {

        if (!StringUtils.hasLength(risco)) {
            return null;
        }

        for (RiscoProjeto p: RiscoProjeto.values()) {
            if (risco.equals(p.getRisco())) {
                return p;
            }
        }
        throw new RiscoInvalidoException("Risco inválido:" + risco);
    }
}
