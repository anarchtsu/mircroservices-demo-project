CREATE TABLE fraud_check_history
(
    id          SERIAL    NOT NULL PRIMARY KEY,
    customer_id INTEGER   NOT NULL,
    fraudster   BOOLEAN   NOT NULL,
    created_at  TIMESTAMP NOT NULL
);
