CREATE TABLE IF NOT EXISTS comments (
    id BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    text VARCHAR(255) NOT NULL,
    author_id BIGINT NOT NULL,
    author_name VARCHAR NOT NULL,
    event_id BIGINT NOT NULL,
    created TIMESTAMP WITHOUT TIME ZONE
);