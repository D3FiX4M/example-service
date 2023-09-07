CREATE TABLE account
(
    id          UUID                        NOT NULL,
    email       VARCHAR(255)                NOT NULL,
    password    VARCHAR(255)                NOT NULL,
    status      VARCHAR(255)                NOT NULL,
    role_id     BIGINT                      NOT NULL,
    language_id BIGINT                      NOT NULL,
    timezone_id BIGINT                      NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_account PRIMARY KEY (id)
);

ALTER TABLE account
    ADD CONSTRAINT uc_account_email UNIQUE (email);