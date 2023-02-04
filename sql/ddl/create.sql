create schema if not exists spring_data;

create table if not exists spring_data.user
(
  id varchar(16) primary key not null,
  gender varchar(2) not null,
  name varchar(16) not null,
  age int not null,
  location varchar(64),
  country varchar(16)
);