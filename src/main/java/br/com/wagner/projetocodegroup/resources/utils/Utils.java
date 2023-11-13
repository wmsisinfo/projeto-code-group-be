package br.com.wagner.projetocodegroup.resources.utils;

import br.com.wagner.projetocodegroup.domain.Projeto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class Utils {
    public static ResponseEntity<Object> getObjectResponseEntity(Long id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
}
