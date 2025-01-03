CREATE TABLE users
(
    id          BIGINT PRIMARY KEY,
    first_name  VARCHAR(50)  NOT NULL,
    second_name VARCHAR(50)  NOT NULL,
    email       VARCHAR(100) NOT NULL
);

INSERT INTO users (id, first_name, second_name, email)
VALUES (1,'Vlad', 'Tepes','vlad@example.com'),
       (2,'Petru','Rares', 'petru@example.com'),
       (3,'Dimitrie','Cantemir', 'dimitrie@example.com'),
       (4,'Ion','Creanga', 'ion@example.com');
