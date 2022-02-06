create table track_point
(
    id          bigint auto_increment,
    time        datetime not null,
    lat         double   not null,
    lon         double   not null,
    activity_id bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (activity_id) REFERENCES activities (id)
);