create sequence employee_id_seq start 1 increment 1;
create sequence work_place_sequence start 1 increment 1;

create table employee_entity
(
    id       int8 not null,
    email    varchar(255),
    login    varchar(255),
    name     varchar(255),
    password varchar(255),
    primary key (id)
);

create table work_place_entity
(
    id          int8 not null,
    id_employee int8,
    size        int4,
    primary key (id)
);