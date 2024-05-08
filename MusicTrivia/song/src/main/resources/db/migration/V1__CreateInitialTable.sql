CREATE TABLE song
(
    id              int             NOT NULL AUTO_INCREMENT,
    song_name       varchar(50)     NOT NULL,
    artist_name     varchar(50)     NOT NULL,
    genre           varchar(50)     NOT NULL,
    publish_year    datetime        NOT NULL,
    PRIMARY KEY (id)
);