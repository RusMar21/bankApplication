create table if not exists User_info (
    id identity,
    username varchar(50) not null,
    password varchar(50) not null,
    fullname varchar(50) not null
);

create table if not exists Card (
    id identity,
    cardNumber varchar(50) not null,
    cardExpiretion varchar(50) not null,
    cardCVV varchar(50) not null
);

create table if not exists Transaction_table (
    id identity,
    type varchar(10) not null,
    sum int not null,
    dateOfTransaction timestamp not null
);
