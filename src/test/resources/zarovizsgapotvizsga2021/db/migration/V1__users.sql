create table users
(
    id       bigint auto_increment,
    username varchar(255),
    constraint pk_users primary key (id)
);

create table messages
(
    id          bigint auto_increment,
    sender_id   bigint,
    receiver_id varchar(255),
    message     varchar(255),
    constraint pk_emails primary key (id)
);