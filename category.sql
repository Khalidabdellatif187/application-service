create database e_commerce;

Use e_commerce;

create table category(
id bigint primary Key auto_increment,
category_name varchar(225),
description varchar(225),
image_url varchar(225)
);