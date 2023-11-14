package br.com.wagner.projetocodegroup.repository;

import br.com.wagner.projetocodegroup.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

    @Query( value = "SELECT u FROM Pessoa u where u.funcionario = TRUE ORDER BY u.nome")
    List<Pessoa> listFuncionarios();

}
