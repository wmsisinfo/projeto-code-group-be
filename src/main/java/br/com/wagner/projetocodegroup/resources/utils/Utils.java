package br.com.wagner.projetocodegroup.resources.utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class Utils {
    private Utils(){}
    public static ResponseEntity<Object> getPostObjectResponseEntity(Long id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).build();
    }
    public static ResponseEntity<Object> getPutObjectResponseEntity(Long id) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.ok(uri);
    }
}