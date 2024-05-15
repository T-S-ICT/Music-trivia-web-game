CREATE TABLE users
(
    id              int             NOT NULL AUTO_INCREMENT,
    username        varchar(50)     NOT NULL,
    email           varchar(50)     NOT NULL,
    password        varchar(150)     NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user_role
(
    id        int         NOT NULL AUTO_INCREMENT,
    users_id  int         NOT NULL,
    role_name varchar(50) NOT NULL,
    PRIMARY KEY (id),
    UNIQUE (users_id, role_name),
    FOREIGN KEY (users_id) REFERENCES users (id)
);