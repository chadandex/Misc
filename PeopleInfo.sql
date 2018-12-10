DROP DATABASE IF EXISTS peopleinfo;

CREATE DATABASE peopleinfo;

USE peopleinfo;

CREATE TABLE IF NOT EXISTS Person ( 
	personId INT NOT NULL AUTO_INCREMENT,
    personName VARCHAR(30) NOT NULL,
    personAge  VARCHAR(3),
    personTitle VARCHAR(30) NOT NULL,
    personHTown VARCHAR(45),
    PRIMARY KEY(personId)
);