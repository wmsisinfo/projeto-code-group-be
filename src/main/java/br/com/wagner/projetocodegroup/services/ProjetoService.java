package br.com.wagner.projetocodegroup.services;

import br.com.wagner.projetocodegroup.domain.Projeto;
import br.com.wagner.projetocodegroup.dto.projetos.CreateProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.UpdateProjetoDto;
import br.com.wagner.projetocodegroup.repository.ProjetoRepository;
import br.com.wagner.projetocodegroup.services.exception.DeleteProjetoForbidenException;
import br.com.wagner.projetocodegroup.services.exception.ObjectNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjetoService {
    final ProjetoRepository repo;

    public ProjetoService(ProjetoRepository repo) {
        this.repo = repo;
    }

    public Projeto find(Long codigo) {
        Optional<Projeto> obj = repo.findById(codigo);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Cadastro não encontrado:" + codigo + "." + Projeto.class.getName()));
    }

    public Projeto save(CreateProjetoDto dto) {
        Projeto projeto = new Projeto(null, dto.getNome(), dto.getDataInicio(), dto.getDataPrevisaoFim(), dto.getDataFim(), dto.getDescricao(), dto.getStatus(), dto.getOrcamento(), dto.getRisco(), dto.getIdGerente());
        return repo.save(projeto);
    }

    public Projeto update(UpdateProjetoDto dto) {
        var newObj = repo.findById(dto.getId()).orElse(null);
        if (newObj != null) {
            newObj.setNome(dto.getNome());
            newObj.setDescricao(dto.getDescricao());
            newObj.setRisco(dto.getRisco());
            newObj.setOrcamento(dto.getOrcamento());
            newObj.setDataFim(dto.getDataFim());
            newObj.setDataInicio(dto.getDataInicio());
            newObj.setStatus(dto.getStatus());
            newObj.setDataPrevisaoFim(dto.getDataPrevisaoFim());
            newObj.setIdGerente(dto.getIdGerente());
            repo.save(newObj);
        }
        return newObj;
    }

    public Projeto update(Projeto projeto) {
        repo.save(projeto);
        return projeto;
    }

    public void delete(Long id) {
        var projeto = find(id);
        if (projeto.getStatus() == "INICIADO" ||
        projeto.getStatus() == "EM ANDAMENTO" ||
        projeto.getStatus() == "ENCERRADO")
            throw new DeleteProjetoForbidenException("Projeto nao pode ser excluido !");
        repo.delete(projeto);
    }
}
