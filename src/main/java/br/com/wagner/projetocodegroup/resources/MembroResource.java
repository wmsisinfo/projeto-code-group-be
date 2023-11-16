package br.com.wagner.projetocodegroup.resources;

import br.com.wagner.projetocodegroup.dto.membros.CreateAssociacaoMembroProjetoDto;
import br.com.wagner.projetocodegroup.resources.utils.Utils;
import br.com.wagner.projetocodegroup.services.MembroService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/membro")
public class MembroResource {
    private final MembroService service;

    public MembroResource(MembroService service) {
        this.service = service;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody CreateAssociacaoMembroProjetoDto dto) {
        var obj = service.save(dto);
        return Utils.getPostObjectResponseEntity(obj.getIdProjeto());
    }
}
