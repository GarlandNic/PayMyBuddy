
DROP DATABASE IF EXISTS mypaybuddy_tests

create database mypaybuddy_tests;
use mypaybuddy_tests;

create table users(
EMAIL varchar(255) PRIMARY KEY,
PASSWORD varchar(63) NOT NULL,
BALANCE integer unsigned
);

create table friends(
 ID int PRIMARY KEY AUTO_INCREMENT,
 PARKING_NUMBER int NOT NULL,
 VEHICLE_REG_NUMBER varchar(10) NOT NULL,
 PRICE double,
 IN_TIME DATETIME NOT NULL,
 OUT_TIME DATETIME,
 FOREIGN KEY (PARKING_NUMBER)
 REFERENCES parking(PARKING_NUMBER));

create table transactions(
 ID int PRIMARY KEY AUTO_INCREMENT,
 PARKING_NUMBER int NOT NULL,
 VEHICLE_REG_NUMBER varchar(10) NOT NULL,
 PRICE double,
 IN_TIME DATETIME NOT NULL,
 OUT_TIME DATETIME,
 FOREIGN KEY (PARKING_NUMBER)
 REFERENCES parking(PARKING_NUMBER));
 
commit;


