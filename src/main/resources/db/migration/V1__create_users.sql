CREATE TABLE users
(
    id          BIGINT PRIMARY KEY,
    first_name  VARCHAR(50)  NOT NULL,
    second_name VARCHAR(50)  NOT NULL,
    email       VARCHAR(100) NOT NULL
);

INSERT INTO users (id, first_name, second_name, email)
VALUES (1, 'Leonardo', 'DiCaprio', 'leo@hollywood.com'),
       (2, 'Brad', 'Pitt', 'brad@hollywood.com'),
       (3, 'Scarlett', 'Johansson', 'scarlett@hollywood.com'),
       (4, 'Natalie', 'Portman', 'natalie@hollywood.com'),
       (5,'Tom', 'Cruise','tom@gmail.com');

