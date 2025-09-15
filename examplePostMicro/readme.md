### create table in cassandra

USE postsdb;

CREATE TABLE IF NOT EXISTS posts (
id UUID PRIMARY KEY,
titulo text,
contenido text,
user_id UUID
);


###  entry cassandra
docker exec -it cassandra cqlsh
