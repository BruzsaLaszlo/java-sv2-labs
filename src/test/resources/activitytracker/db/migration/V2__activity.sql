create table track_point
(
    id          bigint auto_increment primary key,
    time        datetime not null,
    lat         double   not null,
    lon         double   not null,
    activity_id bigint,
    FOREIGN KEY (activity_id) REFERENCES activities (id)
);