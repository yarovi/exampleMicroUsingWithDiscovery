package org.yasmani.io.examplepostmicro.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.yasmani.io.examplepostmicro.domain.Post;
import org.yasmani.io.examplepostmicro.dto.PostRequest;
import org.yasmani.io.examplepostmicro.dto.PostResponse;
import org.yasmani.io.examplepostmicro.mapper.PostMapper;
import org.yasmani.io.examplepostmicro.repository.PostRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class PostService {

    Logger Log = LoggerFactory.getLogger(PostService.class);
    private final PostRepository repo;
    private final PostMapper mapper;

    public PostService(PostRepository repo, PostMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public PostResponse crear(PostRequest request) {
        try{
        Post post = mapper.toEntity(request);
        post.setId(UUID.randomUUID());
        return mapper.toResponse(repo.save(post));
        }catch (Exception e){
            Log.error("Error al crear el post: {}", e.getMessage());
            throw new IllegalArgumentException("Error al crear el post: " + e.getMessage());
        }
    }

    public Optional<PostResponse> obtener(UUID id) {
        return repo.findById(id).map(mapper::toResponse);
    }

    public void eliminar(UUID id) {
        repo.deleteById(id);
    }
}