package br.com.wagner.projetocodegroup.dto.membros;
import br.com.wagner.projetocodegroup.domain.Projeto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateAssociacaoMembroProjetoDto {

    @NotNull
    private Long idProjeto;
    @NotNull
    private Long idPessoa;
    @NotNull
    private String atribuicao;
}
