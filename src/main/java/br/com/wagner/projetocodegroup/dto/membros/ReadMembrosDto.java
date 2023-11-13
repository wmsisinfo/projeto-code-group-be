package br.com.wagner.projetocodegroup.dto.membros;

import br.com.wagner.projetocodegroup.domain.Membro;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReadMembrosDto {

    public ReadMembrosDto() {

    }

    public ReadMembrosDto(Membro membro) {
        this.id = membro.getId();



    }

    private Long id;
    private String nome;
}
