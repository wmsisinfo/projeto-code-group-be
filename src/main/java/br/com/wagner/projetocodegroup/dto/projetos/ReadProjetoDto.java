package br.com.wagner.projetocodegroup.dto.projetos;

import br.com.wagner.projetocodegroup.domain.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class ReadProjetoDto implements Serializable {

    public ReadProjetoDto() {
    }

    public ReadProjetoDto(Projeto projeto) {
        this.id = projeto.getId();
        this.dataFim = projeto.getDataFim();
        this.dataInicio = projeto.getDataInicio();
        this.nome = projeto.getNome();
        this.descricao = projeto.getDescricao();
        this.dataPrevisaoFim = projeto.getDataPrevisaoFim();
        this.orcamento = projeto.getOrcamento();
        this.status = projeto.getStatus();
        this.idGerente = projeto.getIdGerente();
        this.risco = projeto.getRisco();
    }


    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataPrevisaoFim;
    private LocalDate dataFim;

    private String descricao;
    private String status;
    private String risco;

    private Double orcamento;
    private Long idGerente;

}
