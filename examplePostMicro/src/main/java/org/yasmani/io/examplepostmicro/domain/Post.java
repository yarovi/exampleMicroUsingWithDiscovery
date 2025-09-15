package org.yasmani.io.examplepostmicro.domain;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Data
@Table( "posts")
public class Post {

    @PrimaryKey
    private UUID id;

    @Column("titulo")
    private String title;

    @Column("contenido")
    private String content;

    @Column("user_id")
    private UUID userId;
}
