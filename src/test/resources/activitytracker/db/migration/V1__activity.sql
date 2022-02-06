create table activities
(
    id            bigint auto_increment,
    start_time    datetime     not null,
    activity_desc varchar(255) not null,
    activity_type varchar(45)  not null,
    PRIMARY KEY (id)
);