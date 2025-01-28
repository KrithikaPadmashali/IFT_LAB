drop database CRICKET;
CREATE DATABASE CRICKET;

USE CRICKET;
CREATE TABLE PLAYER(
player_id int auto_increment primary key,
first_name varchar(55),
last_name varchar(55),
dob date,
nationality varchar(55),
role varchar(50) 
);
CREATE TABLE STADIUM(
statdium_id int primary key,
statidium_name varchar(30),
location varchar(30),
capacity int
);

CREATE TABLE BOWLER(
bowler_id int auto_increment primary key,
player_id int,
matches int,
wickets int,
economy_rate decimal(10,2),
bowling_avg decimal(10,2),
foreign key (player_id) references PLAYER(player_id)
);
CREATE TABLE BATTER(
batter_id int auto_increment primary key,
player_id int,
matches int,
strikes int,
strike_rate decimal(10,2),
batting_avg decimal(10,2),
foreign key (player_id) references PLAYER(player_id)
);
