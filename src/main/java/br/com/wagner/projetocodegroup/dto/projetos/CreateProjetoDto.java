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
public class CreateProjetoDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    @NotEmpty
    private String nome;
    @NotNull
    private LocalDate dataInicio;
    @NotNull
    private LocalDate dataPrevisaoFim;

    private LocalDate dataFim;

    @NotEmpty
    private String descricao;

    private String status;

    @NotNull
    private Double orcamento;
    @NotNull
    private String risco;
    @NotNull
    private Long idGerente;


}
