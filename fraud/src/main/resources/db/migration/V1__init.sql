CREATE TABLE fraud_check_history
(
    id         SERIAL       NOT NULL PRIMARY KEY,
    email      VARCHAR(256) NOT NULL,
    fraudster  BOOLEAN      NOT NULL,
    created_at TIMESTAMP    NOT NULL
);

create unique index on fraud_check_history (email);
