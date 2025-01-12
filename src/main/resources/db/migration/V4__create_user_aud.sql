CREATE TABLE user_aud
(
    id          BIGINT NOT NULL,
    first_name  VARCHAR(255),
    second_name VARCHAR(255),
    email       VARCHAR(255),
    password    VARCHAR(255),
    rev         BIGINT NOT NULL,
    revtstmp    TIMESTAMP       DEFAULT CURRENT_TIMESTAMP,
    revtype     INT    NOT NULL DEFAULT 0,
    PRIMARY KEY (id, rev)
);
