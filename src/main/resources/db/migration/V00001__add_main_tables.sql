DROP TABLE IF EXISTS tg_user;

CREATE TABLE tg_user
(
    chat_id INT NOT NULL,
    active  BOOLEAN,
    PRIMARY KEY (chat_id)
);

DROP TABLE IF EXISTS compliments;

CREATE TABLE compliment
(
    id          SERIAL PRIMARY KEY,
    description VARCHAR(255)
);