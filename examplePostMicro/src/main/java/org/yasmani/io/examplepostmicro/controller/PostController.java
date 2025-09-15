package org.yasmani.io.examplepostmicro.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yasmani.io.examplepostmicro.dto.PostRequest;
import org.yasmani.io.examplepostmicro.dto.PostResponse;
import org.yasmani.io.examplepostmicro.service.PostService;

import java.util.UUID;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService service;

    public PostController(PostService service) {
        this.service = service;
    }

    @PostMapping
    public PostResponse crear(@RequestBody PostRequest request) {
        return service.crear(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> obtener(@PathVariable UUID id) {
        return service.obtener(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable UUID id) {
        service.eliminar(id);
    }
}
