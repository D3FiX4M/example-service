CREATE TABLE users
(
    id          UUID                        NOT NULL,
    email       VARCHAR(255)                NOT NULL,
    password    VARCHAR(255)                NOT NULL,
    status      VARCHAR(255)                NOT NULL,
    role_id     BIGINT                      NOT NULL,
    language_id BIGINT                      NOT NULL,
    timezone_id BIGINT                      NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (id)
);

ALTER TABLE users
    ADD CONSTRAINT uc_users_email UNIQUE (email);