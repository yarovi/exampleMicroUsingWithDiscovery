package org.yasmani.io.exampleusermicro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.yasmani.io.exampleusermicro.domain.Usuario;

import java.util.Optional;
import java.util.UUID;

public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    boolean existsByEmail(String email);
    Optional<Usuario> findByEmail(String email);
}
