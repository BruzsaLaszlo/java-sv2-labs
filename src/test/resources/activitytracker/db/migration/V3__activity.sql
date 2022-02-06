create table image
(
    id          bigint auto_increment,
    content     blob,
    activity_id bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (activity_id) REFERENCES activities (id)
);