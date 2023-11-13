package br.com.wagner.projetocodegroup.domain.enums;

import org.springframework.util.StringUtils;

public enum Atribuicao {

    GERENTE("GERENTE"),
    FUNCIONARIO("FUNCIONARIO");

    public String getAtribuicaoFuncionario() {
        return atribuicaoFuncionario;
    }

    private final String atribuicaoFuncionario;

    Atribuicao(String atribuicao) {
        this.atribuicaoFuncionario = atribuicao;
    }

    public static Atribuicao stringToEnum(String atribuicao) {

        if (!StringUtils.hasLength(atribuicao)) {
            return null;
        }

        for (Atribuicao r : Atribuicao.values()) {
            if (atribuicao.equals(r.getAtribuicaoFuncionario())) {
                return r;
            }
        }
        throw new IllegalArgumentException("Atribuição de funcionário inválida:" + atribuicao);
    }

    public static Atribuicao toEnum(String atribuicao) {

        if (!StringUtils.hasLength(atribuicao)) {
            return null;
        }

        for (Atribuicao p: Atribuicao.values()) {
            if (atribuicao.equals(p.getAtribuicaoFuncionario())) {
                return p;
            }
        }
        throw new IllegalArgumentException("Atribuição do funcionário inválida:" + atribuicao);
    }
}
