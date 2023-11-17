package br.com.wagner.projetocodegroup.resources.utils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

public class Utils {
    private Utils(){}
    public static ResponseEntity<Object> getPostObjectResponseEntity(Long id, Object dto) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
        return ResponseEntity.created(uri).body(dto);
    }
    public static ResponseEntity<Object> getPutObjectResponseEntity(Object dto) {
        return ResponseEntity.ok(dto);
    }
}