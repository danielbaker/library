DROP TABLE IF EXISTS People;

CREATE TABLE People (
  id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name VARCHAR(500) NOT NULL,
  email_address VARCHAR(500) NOT NULL,
  phone_number VARCHAR(500) NOT NULL
);

DROP TABLE IF EXISTS Books;

CREATE TABLE Books (
  id BIGINT AUTO_INCREMENT NOT NULL PRIMARY KEY,
  title VARCHAR(500) NOT NULL,
  author VARCHAR(500) NOT NULL,
  isbn VARCHAR(500) NOT NULL,
  rented_by BIGINT
);