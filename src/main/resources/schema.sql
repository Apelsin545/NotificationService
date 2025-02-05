CREATE TABLE IF NOT EXISTS notifications
(
    id      bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    user_id bigint NOT NULL,
    message VARCHAR(128) NOT NULL,
    send_at TIMESTAMP NOT NULL
);