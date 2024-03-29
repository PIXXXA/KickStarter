create sequence hibernate_sequence start 1 increment 1;
create table comment (
id int8 not null,
filename varchar(255),
 text varchar(255),
 user_id int8,
 primary key (id));
create table company (
id int8 not null,
coast int4,
description varchar(255),
filename varchar(255),
name varchar(255),
user_id int8,
 primary key (id));
create table user_role (
user_id int8 not null,
roles varchar(255));
create table usr (
id int8 not null,
activation_code varchar(255),
active boolean not null,
email varchar(255),
password varchar(255),
username varchar(255),
primary key (id));
alter table if exists comment add constraint comment_user_fk foreign key (user_id) references usr;
alter table if exists company add constraint company_user_fk foreign key (user_id) references usr;
alter table if exists user_role add constraint user_role_user_fk foreign key (user_id) references usr;