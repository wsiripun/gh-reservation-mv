DROP DATABASE IF EXISTS wijs_reservation;
CREATE DATABASE wijs_reservation;
USE wijs_reservation;
CREATE TABLE attendant (
    id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
    firstName VARCHAR(30) NOT NULL,
    lastName VARCHAR(30) NOT NULL,
    email VARCHAR(50),
    phoneNumber VARCHAR(50)
    -- regDate TIMESTAMP
    );