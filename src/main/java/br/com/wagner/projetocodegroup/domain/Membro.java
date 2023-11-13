package br.com.wagner.projetocodegroup.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "membros")
public class Membro {

    @Id
    @Column(name = "idprojeto", nullable = false)
    private Long idProjeto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idpessoa", nullable = false)
    private Pessoa pessoa;

}