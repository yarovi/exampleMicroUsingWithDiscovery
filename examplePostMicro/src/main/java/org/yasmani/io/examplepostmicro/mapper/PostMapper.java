package org.yasmani.io.examplepostmicro.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.yasmani.io.examplepostmicro.domain.Post;
import org.yasmani.io.examplepostmicro.dto.PostRequest;
import org.yasmani.io.examplepostmicro.dto.PostResponse;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(source="postRequest.userId", target="userId")
    @Mapping(source="postRequest.titulo", target="title")
    @Mapping(source="postRequest.contenido", target="content")
    Post toEntity(PostRequest postRequest);

    @Mapping(source="userId", target = "userId")
    @Mapping(source="title", target = "titulo")
    @Mapping(source="content", target = "contenido")
    PostResponse toResponse(Post post);
}
