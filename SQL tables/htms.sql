create database hotelmanagementsystem;
show databases;
use hotelmanagementsystem;
show TABLES;

create table login(username varchar(25),password varchar(25));
insert into login values('admin','12345');


create table employee(name varchar(25),age varchar(10),gender varchar(15),job varchar(30),salary varchar(15),phone varchar(15),email varchar(35),aadhar varchar(20));


create table room(roomnumber varchar(20),availability varchar(20),cleaning_status varchar(20),price varchar(20),bed_type varchar(20));


create table driver(name varchar(30),age varchar(10),gender varchar(15),company varchar(20),brand varchar(30),available varchar(30),location varchar(35));


create table customer(document varchar(25),number varchar(30),name varchar(35),gender varchar(20),country varchar(35),room varchar(35),checkintime varchar(35),deposit varchar(32));


create table department(dapartment varchar(30),budget varchar(30));


insert into department values('Front office','500000');
insert into department values('Housekeeping','40000');
insert into department values('Food and Beverage','23000');
insert into department values('Kitchen or Food Production','540000');
insert into department values('Security','320000');

select *from employee;
select * from login;
select * from driver;
select *from room;
select * from department;
select * from customer;