package br.com.wagner.projetocodegroup.services;

import br.com.wagner.projetocodegroup.domain.Membro;
import br.com.wagner.projetocodegroup.domain.enums.Atribuicao;
import br.com.wagner.projetocodegroup.dto.membros.CreateAssociacaoMembroProjetoDto;
import br.com.wagner.projetocodegroup.repository.MembroRepository;
import br.com.wagner.projetocodegroup.services.exception.NaoFuncionarioException;
import org.springframework.stereotype.Service;

@Service
public class MembroService {
    final MembroRepository repo;

    final PessoaService pessoaService;

    final ProjetoService projetoService;

    public MembroService(MembroRepository repo, PessoaService pessoaService, ProjetoService projetoService) {
        this.repo = repo;
        this.pessoaService = pessoaService;
        this.projetoService = projetoService;
    }

    public Membro save(CreateAssociacaoMembroProjetoDto dto) {

        var atribuicao = Atribuicao.stringToEnum(dto.getAtribuicao().toUpperCase());
        var pessoa = pessoaService.find(dto.getIdPessoa());
        if (Boolean.FALSE.equals(pessoa.getFuncionario()))
            throw new NaoFuncionarioException("Id:" + dto.getIdPessoa() + "Nao é funcionário");
        var projeto = projetoService.find(dto.getIdProjeto());
        if (atribuicao == Atribuicao.GERENTE && !projeto.getIdGerente().equals(dto.getIdPessoa())) {
            projeto.setIdGerente(dto.getIdPessoa());
            projetoService.update(projeto);
        }
        var membro = new Membro(dto.getIdProjeto(),pessoa);
        return repo.save(membro);
    }
}
