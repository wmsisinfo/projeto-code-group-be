package br.com.wagner.projetocodegroup.dto.pessoas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReadPessoaDto {

    private Long id;
    private String nome;
}
