package br.com.wagner.projetocodegroup.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projeto")
public class Projeto {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", nullable = false, length = 200)
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_previsao_fim")
    private LocalDate dataPrevisaoFim;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "descricao", length = 5000)
    private String descricao;

    @Column(name = "status", length = 45)
    private String status;

    @Column(name = "orcamento")
    private Double orcamento;

    @Column(name = "risco", length = 45)
    private String risco;

    @Column(name = "idgerente")
    private Long idGerente;

}