#CREATE DATABASE library;

CREATE TABLE readers (
    id integer(10)  NOT NULL AUTO_INCREMENT,
    first_name varchar(50),
    second_name varchar(50),
    birth_date date,
    PRIMARY KEY (id)
);

CREATE TABLE authors (
    id integer(10)  NOT NULL AUTO_INCREMENT,
    first_name varchar(50),
    second_name varchar(50),
    birth_date date,
    PRIMARY KEY (id)
);

CREATE TABLE books (
    id integer(10)  NOT NULL AUTO_INCREMENT,
    book_name varchar(50),
    description varchar(255),
    print_year integer(10),
    PRIMARY KEY (id)
);

CREATE TABLE genres (
    id integer(10)  NOT NULL AUTO_INCREMENT,
    genre varchar(20),
    description varchar(255),
    PRIMARY KEY (id)
);


CREATE TABLE books_authors (
    id integer(10)  NOT NULL AUTO_INCREMENT,
    authors_id integer(10),
    books_id integer(10),
    PRIMARY KEY (id)
);

CREATE TABLE books_genres (
    id integer(10)  NOT NULL AUTO_INCREMENT,
	books_id integer(10),
    genres_id integer(10),
    PRIMARY KEY (id)
);


CREATE TABLE books_readers (
    id integer(10)  NOT NULL AUTO_INCREMENT,
	books_dictionary_id integer(10),
    readers_id integer(10),
    take_date date,
    return_date date,
    PRIMARY KEY (id)
);