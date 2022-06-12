SHOW
DATABASES ;
CREATE
DATABASE Thogakade;
USE
Thogakade;
CREATE TABLE system_user
(
    name     VARCHAR(45)  NOT NULL,
    email    VARCHAR(100) NOT NULL PRIMARY KEY,
    password TEXT
);
DESC system_user;
CREATE TABLE customer
(
    id      VARCHAR(45) NOT NULL PRIMARY KEY,
    name    VARCHAR(45) NOT NULL,
    address TEXT,
    salary  DECIMAL(10, 2) DEFAULT 0
);
DESCRIBE customer;

CREATE TABLE Item
(
    code      VARCHAR(45) NOT NULL PRIMARY KEY,
    description    VARCHAR(45) NOT NULL,
    qtyOnHand INT,
    unitPrice  DECIMAL(10, 2) DEFAULT 0
);
DESCRIBE Item;