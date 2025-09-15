package org.yasmani.io.exampleusermicro.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yasmani.io.exampleusermicro.domain.Usuario;
import org.yasmani.io.exampleusermicro.dto.UserRequest;
import org.yasmani.io.exampleusermicro.dto.UserResponse;
import org.yasmani.io.exampleusermicro.mapper.UsuarioMapper;
import org.yasmani.io.exampleusermicro.repository.UsuarioRepository;

import java.util.UUID;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final UsuarioMapper mapper;

    public UsuarioService(UsuarioRepository repo, UsuarioMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional
    public UserResponse crear(UserRequest request) {
        if (repo.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email ya está registrado");
        }
        Usuario entity = mapper.toEntity(request);
        entity = repo.save(entity);
        return mapper.toResponse(entity);
    }

    @Transactional
    public UserResponse actualizar(UUID id, UserRequest request) {
        Usuario entity = repo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
        // si cambia el email, validamos unicidad
        if (!entity.getEmail().equalsIgnoreCase(request.email()) && repo.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Email ya está registrado");
        }
        mapper.update(entity, request);
        return mapper.toResponse(entity);
    }

    public UserResponse obtener(UUID id) {
        return repo.findById(id)
                .map(mapper::toResponse)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado"));
    }

    public void eliminar(UUID id) {
        if (!repo.existsById(id)) {
            throw new IllegalArgumentException("Usuario no encontrado");
        }
        repo.deleteById(id);
    }
}
