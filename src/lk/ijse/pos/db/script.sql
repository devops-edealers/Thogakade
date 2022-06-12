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
    code        VARCHAR(45) NOT NULL PRIMARY KEY,
    description VARCHAR(45) NOT NULL,
    qtyOnHand   INT,
    unitPrice   DECIMAL(10, 2) DEFAULT 0
);

CREATE TABLE `Order`
(
    orderId    VARCHAR(45),
    date       DATE NOT NULL,
    cost       DOUBLE,
    customerId VARCHAR(45),
    CONSTRAINT PRIMARY KEY (orderId),
    CONSTRAINT FOREIGN KEY (customerId)
        REFERENCES Customer (id)
        ON UPDATE CASCADE ON DELETE CASCADE
);
DESC `Order`;
CREATE TABLE `Order detail`
(
    orderId    VARCHAR(45),
    itemCode    VARCHAR(45),
    cost       DOUBLE,
    CONSTRAINT PRIMARY KEY (orderId, itemCode),
    CONSTRAINT FOREIGN KEY (orderId)
        REFERENCES `Order` (orderId)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT FOREIGN KEY (itemCode)
        REFERENCES `Item` (code)
        ON UPDATE CASCADE ON DELETE CASCADE
);
DESC `Order Detail`;
