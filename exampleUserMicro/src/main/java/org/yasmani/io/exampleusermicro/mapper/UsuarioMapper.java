package org.yasmani.io.exampleusermicro.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;
import org.yasmani.io.exampleusermicro.domain.Usuario;
import org.yasmani.io.exampleusermicro.dto.UserRequest;
import org.yasmani.io.exampleusermicro.dto.UserResponse;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UserRequest request);

    UserResponse toResponse(Usuario entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void update(@MappingTarget Usuario target, UserRequest source);
}
