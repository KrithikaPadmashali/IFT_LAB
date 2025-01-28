drop database super_market ;
create database super_market;
use super_market;
create table product(
product_id int auto_increment primary key,
product_name varchar(50),
category varchar(50),
price decimal(10,2),
stock_quantity int 
);
create table customer(
customer_id int auto_increment primary key,
first_name varchar(55),
last_name varchar(55),
email varchar(55),
phone_no varchar(55),
address varchar(55)
);
create table orders(
order_id int auto_increment primary key,
customer_id int,
order_date datetime default current_timestamp ,
status varchar(50) ,
foreign key (customer_id) references customer(customer_id)  
);
create table Order_item(
ordr_item_id int auto_increment primary key ,
product_id int,
order_id  int,
quantity int,
price decimal(10,2),
foreign key (product_id) references product(product_id),
foreign key (order_id) references orders(order_id)
);
create table Transactions(
transaction_id int auto_increment primary key,
order_id int,
transaction_date datetime default current_timestamp,
total_amount decimal(10,2),
mode_of_payment varchar(55),
foreign key (order_id) references orders(order_id)
);

 