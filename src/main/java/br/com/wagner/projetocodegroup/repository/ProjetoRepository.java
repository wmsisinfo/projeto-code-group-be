package br.com.wagner.projetocodegroup.repository;

import br.com.wagner.projetocodegroup.domain.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}
