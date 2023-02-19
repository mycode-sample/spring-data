create schema if not exists spring_data;

drop table spring_data.user;
create table if not exists spring_data.user
(
  id varchar(32) primary key not null,
  gender varchar(2) not null,
  name varchar(16) not null,
  age int not null,
  location varchar(64),
  country varchar(16)
);

drop table spring_data.person;
create table if not exists spring_data.person
(
  id varchar(32) primary key not null,
  address_id varchar(32)
);

drop table spring_data.address;
create table if not exists spring_data.address
(
  id varchar(32) primary key not null,
  zip_code varchar(32)
);