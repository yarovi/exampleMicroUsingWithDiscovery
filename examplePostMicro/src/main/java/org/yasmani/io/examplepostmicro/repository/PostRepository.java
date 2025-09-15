package org.yasmani.io.examplepostmicro.repository;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import org.yasmani.io.examplepostmicro.domain.Post;

import java.util.UUID;

@Repository
public interface PostRepository extends CassandraRepository<Post, UUID> {
}
