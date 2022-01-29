CREATE TABLE notification
(
    id      serial       not null primary key,
    message text         not null,
    send_to VARCHAR(255) not null
);
