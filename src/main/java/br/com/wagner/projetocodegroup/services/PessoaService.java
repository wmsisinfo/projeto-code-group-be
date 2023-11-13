package br.com.wagner.projetocodegroup.services;

import br.com.wagner.projetocodegroup.domain.Pessoa;
import br.com.wagner.projetocodegroup.repository.PessoaRepository;
import br.com.wagner.projetocodegroup.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    final PessoaRepository repo;

    public PessoaService(PessoaRepository repo) {
        this.repo = repo;
    }

    public Pessoa find(Long codigo) {
        Optional<Pessoa> obj = repo.findById(codigo);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cadastro não encontrado:" + codigo + "." + Pessoa.class.getName()));
    }
}
