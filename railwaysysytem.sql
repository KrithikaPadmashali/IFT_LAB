CREATE DATABASE Railway;
USE Railway;

-- Passenger Table
CREATE TABLE Passenger (
    passenger_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(15),
    gender ENUM('Male', 'Female', 'Other'),
    age INT
);

-- Train Table
CREATE TABLE Train (
    train_id INT AUTO_INCREMENT PRIMARY KEY,
    train_name VARCHAR(100),
    train_type ENUM('Express', 'Superfast', 'Local'),
    total_seats INT
);

-- Station Table
CREATE TABLE Station (
    station_id INT AUTO_INCREMENT PRIMARY KEY,
    station_name VARCHAR(100),
    city VARCHAR(100),
    state VARCHAR(50)
);

-- Route Table (Train connects multiple stations)
CREATE TABLE Route (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    train_id INT,
    source_station INT,
    destination_station INT,
    departure_time DATETIME,
    arrival_time DATETIME,
    FOREIGN KEY (train_id) REFERENCES Train(train_id),
    FOREIGN KEY (source_station) REFERENCES Station(station_id),
    FOREIGN KEY (destination_station) REFERENCES Station(station_id)
);

-- Booking Table
CREATE TABLE Booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_id INT,
    train_id INT,
    seat_no VARCHAR(10),
    class_type ENUM('Sleeper', 'AC1', 'AC2', 'AC3', 'General'),
    booking_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    journey_date DATE,
    status ENUM('Confirmed', 'Waiting', 'Cancelled'),
    FOREIGN KEY (passenger_id) REFERENCES Passenger(passenger_id),
    FOREIGN KEY (train_id) REFERENCES Train(train_id)
);

-- Payment Table
CREATE TABLE Payment (
    payment_id INT AUTO_INCREMENT PRIMARY KEY,
    booking_id INT,
    amount DECIMAL(10,2),
    payment_method ENUM('Credit Card', 'Debit Card', 'UPI', 'Net Banking'),
    payment_status ENUM('Success', 'Failed', 'Pending'),
    payment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (booking_id) REFERENCES Booking(booking_id)
);
