CREATE TABLE IF NOT EXISTS users (
id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
name VARCHAR NOT NULL,
email VARCHAR NOT NULL UNIQUE
);