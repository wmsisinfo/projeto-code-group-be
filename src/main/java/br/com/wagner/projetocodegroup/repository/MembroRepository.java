package br.com.wagner.projetocodegroup.repository;
import br.com.wagner.projetocodegroup.domain.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
}
