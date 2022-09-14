create table if not exists User_info (
    id identity,
    username varchar(50) not null,
    password varchar(250) not null,
    fullname varchar(50) not null,
    primary key(id)
);

create table if not exists Card (
    user_id identity,
    card_Number varchar(50) not null,
    card_Expiration varchar(50) not null,
    card_CVV varchar(50) not null,
    primary key(user_id),
    foreign key(user_id) references User_info(id)
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

create table if not exists user_roles (
    user_id long not null,
    role_id long not null,
    primary key(user_id, role_id),
    foreign key(user_id) references User_info(id),
    foreign key(role_id) references Roles(id)
);

insert into Roles(name) values ('ROLE_USER');
insert into Roles(name) values ('ROLE_ADMIN');

insert into User_info(username, password, fullname) values  ('admin', '$2a$12$/blNkJXtZE4tA7DA5I4ppOpeEIuBs.Audy65iM4jkRcQRyRjir/nm', 'Маров Руслан Джабирович');

insert into user_roles(user_id, role_id) values (1, 2);

insert  into Card(card_Number, card_Expiration, card_CVV) values ('2202202213624806', '10/34', '456');
