create  database Bank;
use Bank;
create table Customer (
  customer_id int auto_increment primary key,
  first_name varchar(100),
  last_name varchar(100),
  email varchar(100),
  phone_no varchar(15),
  address varchar(55)
  );
  create table Credit(
  credit_id int auto_increment primary key,
  customer_id int,
  amount decimal(10,2),
  credit_data datetime default current_timestamp,
  foreign key(customer_id) REFERENCES Customer(customer_id)
  );
  create table Debit (
  debit_id int auto_increment primary key,
  customer_id int,
  amount decimal(10,2),
  debit_date datetime default current_timestamp,
  foreign key(debit_id) references  Customer(customer_id)
  );
  
  
  
  