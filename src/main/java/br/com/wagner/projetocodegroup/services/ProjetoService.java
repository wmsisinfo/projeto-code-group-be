package br.com.wagner.projetocodegroup.services;

import br.com.wagner.projetocodegroup.domain.Projeto;
import br.com.wagner.projetocodegroup.domain.enums.RiscoProjeto;
import br.com.wagner.projetocodegroup.domain.enums.StatusProjeto;
import br.com.wagner.projetocodegroup.dto.projetos.CreateProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.UpdateProjetoDto;
import br.com.wagner.projetocodegroup.repository.ProjetoRepository;
import br.com.wagner.projetocodegroup.services.exception.DeleteProjetoForbidenException;
import br.com.wagner.projetocodegroup.services.exception.ObjectNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Projeto> findAll() {
        return repo.findAll(Sort.by(Sort.Direction.ASC,"id"));
    }

    public Projeto save(CreateProjetoDto dto) {
        RiscoProjeto.stringToEnum(dto.getRisco().toUpperCase());
        StatusProjeto.stringToEnum(dto.getStatus().toUpperCase());
        Projeto projeto = new Projeto(null, dto.getNome(), dto.getDataInicio(), dto.getDataPrevisaoFim(), dto.getDataFim(), dto.getDescricao(), dto.getStatus(), dto.getOrcamento(), dto.getRisco(), dto.getIdGerente());
        return repo.save(projeto);
    }

    public Projeto update(UpdateProjetoDto dto) {
        var newObj = repo.findById(dto.getId()).orElse(null);
        RiscoProjeto.stringToEnum(dto.getRisco().toUpperCase());
        StatusProjeto.stringToEnum(dto.getStatus().toUpperCase());

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
        if (projeto.getStatus().equals("INICIADO") ||
        projeto.getStatus().equals("EM ANDAMENTO") ||
        projeto.getStatus().equals("ENCERRADO"))
            throw new DeleteProjetoForbidenException("Projeto nao pode ser excluido !");
        repo.delete(projeto);
    }
}
