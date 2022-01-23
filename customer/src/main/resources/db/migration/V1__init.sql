CREATE TABLE customer
(
    id         SERIAL       NOT NULL PRIMARY KEY,
    first_name VARCHAR(25)  NOT NULL,
    last_name  VARCHAR(25)  NOT NULL,
    email      VARCHAR(256) NOT NULL
);

CREATE UNIQUE INDEX ON customer(email);
