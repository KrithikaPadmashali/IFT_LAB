CREATE DATABASE Airline;
USE Airline;

-- Passenger Table
CREATE TABLE Passenger (
    passenger_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    email VARCHAR(100),
    phone VARCHAR(15),
    gender ENUM('Male', 'Female', 'Other'),
    age INT,
    passport_no VARCHAR(20) UNIQUE
);

-- Airport Table
CREATE TABLE Airport (
    airport_id INT AUTO_INCREMENT PRIMARY KEY,
    airport_name VARCHAR(100),
    city VARCHAR(100),
    country VARCHAR(50),
    IATA_code VARCHAR(10) UNIQUE
);

-- Flight Table
CREATE TABLE Flight (
    flight_id INT AUTO_INCREMENT PRIMARY KEY,
    airline_name VARCHAR(100),
    flight_number VARCHAR(10) UNIQUE,
    total_seats INT
);

-- Route Table (Flight connects multiple airports)
CREATE TABLE Route (
    route_id INT AUTO_INCREMENT PRIMARY KEY,
    flight_id INT,
    source_airport INT,
    destination_airport INT,
    departure_time DATETIME,
    arrival_time DATETIME,
    FOREIGN KEY (flight_id) REFERENCES Flight(flight_id),
    FOREIGN KEY (source_airport) REFERENCES Airport(airport_id),
    FOREIGN KEY (destination_airport) REFERENCES Airport(airport_id)
);

-- Booking Table
CREATE TABLE Booking (
    booking_id INT AUTO_INCREMENT PRIMARY KEY,
    passenger_id INT,
    flight_id INT,
    seat_no VARCHAR(10),
    class_type ENUM('Economy', 'Business', 'First Class'),
    booking_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    journey_date DATE,
    status ENUM('Confirmed', 'Waiting', 'Cancelled'),
    FOREIGN KEY (passenger_id) REFERENCES Passenger(passenger_id),
    FOREIGN KEY (flight_id) REFERENCES Flight(flight_id)
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
