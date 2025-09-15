-- Crear el keyspace
CREATE KEYSPACE IF NOT EXISTS postsdb
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};

-- Usar el keyspace
USE postsdb;

-- Crear la tabla
CREATE TABLE IF NOT EXISTS posts (
                                     id UUID PRIMARY KEY,
                                     titulo text,
                                     contenido text,
                                     user_id UUID
);
