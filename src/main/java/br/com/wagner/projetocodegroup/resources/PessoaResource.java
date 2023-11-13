package br.com.wagner.projetocodegroup.resources;

import br.com.wagner.projetocodegroup.dto.pessoas.ReadPessoaDto;
import br.com.wagner.projetocodegroup.services.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/pessoa")
public class PessoaResource {

    final PessoaService pessoaService;

    public PessoaResource(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping(value = "/funcionarios")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<ReadPessoaDto>> findFuncionarios() {
        var list = pessoaService.listFuncionarios();
        List<ReadPessoaDto> dto = list.stream().map(obj -> new ReadPessoaDto(obj.getId(), obj.getNome())).toList();
        return ResponseEntity.ok().body(dto);
    }
}
