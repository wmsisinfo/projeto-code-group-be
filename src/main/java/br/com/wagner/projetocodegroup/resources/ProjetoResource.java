package br.com.wagner.projetocodegroup.resources;

import br.com.wagner.projetocodegroup.domain.Projeto;
import br.com.wagner.projetocodegroup.dto.projetos.CreateProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.ReadProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.UpdateProjetoDto;
import br.com.wagner.projetocodegroup.services.exception.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value="/api/v1/projeto")
public class ProjetoResource {

    @Autowired
    ProjetoService service;

    @RequestMapping(value="/{id}", method= RequestMethod.GET)
    public ResponseEntity<?> find(@PathVariable Long id){
        var projeto = service.find(id);
        return ResponseEntity.ok().body(new ReadProjetoDto(projeto));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<?> insert(@Valid @RequestBody CreateProjetoDto dto) {
        var obj = service.save(dto);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(method=RequestMethod.PUT)
    public ResponseEntity<?> update(@Valid @RequestBody UpdateProjetoDto dto) {
        Projeto obj = service.update(dto);
        return ResponseEntity.ok().body(obj);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
