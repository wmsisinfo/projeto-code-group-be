package br.com.wagner.projetocodegroup.resources;

import br.com.wagner.projetocodegroup.domain.Projeto;
import br.com.wagner.projetocodegroup.dto.projetos.CreateProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.ReadProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.UpdateProjetoDto;
import br.com.wagner.projetocodegroup.services.exception.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping(value="/api/v1/projeto")
public class ProjetoResource {

    final ProjetoService service;

    public ProjetoResource(ProjetoService service) {
        this.service = service;
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<?> find(@PathVariable Long id){
        var projeto = service.find(id);
        var dto = new ReadProjetoDto(projeto);
        return ResponseEntity.ok().body(dto);
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody CreateProjetoDto dto) {
        var obj = service.save(dto);
        return getObjectResponseEntity(obj);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdateProjetoDto dto) {
        Projeto obj = service.update(dto);
        return getObjectResponseEntity(obj);
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    private static ResponseEntity<Object> getObjectResponseEntity(Projeto obj) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }


}
