package br.com.wagner.projetocodegroup.repository;

import br.com.wagner.projetocodegroup.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
