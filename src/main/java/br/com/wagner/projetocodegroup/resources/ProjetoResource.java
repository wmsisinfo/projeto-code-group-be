package br.com.wagner.projetocodegroup.resources;

import br.com.wagner.projetocodegroup.domain.Projeto;
import br.com.wagner.projetocodegroup.dto.projetos.CreateProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.ReadProjetoDto;
import br.com.wagner.projetocodegroup.dto.projetos.UpdateProjetoDto;
import br.com.wagner.projetocodegroup.resources.utils.Utils;
import br.com.wagner.projetocodegroup.services.ProjetoService;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value="/api/v1/projeto")
@CrossOrigin(origins = "http://localhost:3000")
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

    @GetMapping
    public ResponseEntity<List<ReadProjetoDto>> findAll(){
        var list = service.findAll();
        List<ReadProjetoDto> dto = list.stream().map(ReadProjetoDto::new).toList();
        return ResponseEntity.ok().body(dto);

    }
    @Transactional
    @PostMapping
    public ResponseEntity<?> insert(@Valid @RequestBody CreateProjetoDto dto) {
        var obj = service.save(dto);
        dto.setId(obj.getId());
        return Utils.getPostObjectResponseEntity(obj.getId(), dto);
    }

    @Transactional
    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody UpdateProjetoDto dto) {
        Projeto obj = service.update(dto);
        return Utils.getPutObjectResponseEntity(obj);
    }

    @DeleteMapping(value="/{id}")
    @Transactional
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
