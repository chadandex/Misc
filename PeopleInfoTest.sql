DROP DATABASE IF EXISTS peopleinfo_test;

CREATE DATABASE peopleinfo_test;

USE peopleinfo_test;

CREATE TABLE IF NOT EXISTS Person ( 
	personId INT NOT NULL AUTO_INCREMENT,
    personName VARCHAR(30) NOT NULL,
    personAge  VARCHAR(3),
    personTitle VARCHAR(30) NOT NULL,
    personHTown VARCHAR(45),
    PRIMARY KEY(personId)
);