drop database if exists cardealershipDB;
create database cardealershipDB;
use cardealershipDB;

-- Superpower
create table cars(
	Id int primary key auto_increment,
    Brand varchar(50) not null,
    Price DECIMAL(8,2) not null,
    isNew boolean default false
);

INSERT INTO `cars` (`Id`,`Brand`,`Price`,`isNew`)
VALUES
	(1,"Toyota",1000.12,true);
