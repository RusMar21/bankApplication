create table if not exists User_info (
    id long,
    username varchar(50) not null,
    password varchar(50) not null,
    fullname varchar(50) not null,
    primary key(id)
);

create table if not exists Card (
    id long,
    cardNumber varchar(50) not null,
    cardExpiretion varchar(50) not null,
    cardCVV varchar(50) not null,
    primary key(id)
);

create table if not exists Transaction_table (
    id identity,
    type varchar(10) not null,
    sum int not null,
    dateOfTransaction timestamp not null
);

create table if not exists Roles (
    id identity,
    name varchar(50) not null,
    primary key(id)
);

insert into Roles(name) values ('ROLE_USER');
insert into Roles(name) values ('ROLE_ADMIN');
