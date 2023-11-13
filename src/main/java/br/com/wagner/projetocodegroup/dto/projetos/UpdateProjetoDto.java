package br.com.wagner.projetocodegroup.dto.projetos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UpdateProjetoDto implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String nome;
    private LocalDate dataInicio;
    private LocalDate dataPrevisaoFim;

    private LocalDate dataFim;

    private String descricao;

    private String status;

    private Double orcamento;
    private String risco;
    private Long idGerente;


}
