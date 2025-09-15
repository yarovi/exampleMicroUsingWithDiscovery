package org.yasmani.io.exampleusermicro.controller;

import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import org.yasmani.io.exampleusermicro.dto.UserRequest;
import org.yasmani.io.exampleusermicro.dto.UserResponse;
import org.yasmani.io.exampleusermicro.service.UsuarioService;

import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService service;
    public UsuarioController(UsuarioService service) { this.service = service; }

    @PostMapping
    public UserResponse crear(@Valid @RequestBody UserRequest request) {
        return service.crear(request);
    }

    @GetMapping("/{id}")
    public UserResponse obtener(@PathVariable UUID id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public UserResponse actualizar(@PathVariable UUID id, @Valid @RequestBody UserRequest request) {
        return service.actualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable UUID id) {
        service.eliminar(id);
    }

    // Opcional: paginado sencillo
    @GetMapping
    public Page<UserResponse> listar(Pageable pageable) {
        // Si quieres mapear a Page<UserResponse>, añade un método en servicio/repositorio para convertir Page<Usuario> a Page<UserResponse>.
        // Para mantener simple, devolvemos vacío aquí o implementa según prefieras.
        return Page.empty(pageable);
    }
}
