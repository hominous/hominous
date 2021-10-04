create table member
(
    id bigint generated by default as identity,
    user_Id varchar(255) not null,
    password varchar(255) not null,
    user_Name varchar(255) not null,
    user_Year number(4) not null,
    user_Month number(4) not null,
    user_Date number(4) not null,
    primary key (id)
);

