CREATE TABLE users
(
    id          BIGSERIAL PRIMARY KEY,
    first_name  VARCHAR(50)  NOT NULL,
    second_name VARCHAR(50)  NOT NULL,
    email       VARCHAR(100) NOT NULL
);

INSERT INTO users (first_name, second_name, email)
VALUES ('Vlad', 'Tepes', 'vlad@example.com'),
       ('Petru', 'Rares', 'petru@example.com'),
       ('Dimitrie', 'Cantemir', 'dimitrie@example.com'),
       ('Ion', 'Creanga', 'ion@example.com');