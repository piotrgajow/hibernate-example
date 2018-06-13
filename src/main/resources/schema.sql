DROP DATABASE IF EXISTS hibernate_example;
CREATE DATABASE hibernate_example;
USE hibernate_example;

CREATE TABLE authors (
    id BIGINT AUTO_INCREMENT,
    name VARCHAR(100),
    surname VARCHAR(255),

    PRIMARY KEY(id)
);

CREATE TABLE books (
    id BIGINT AUTO_INCREMENT,
    title VARCHAR(100) NOT NULL,
    number_of_pages INT,
    has_hard_cover BIT(1),
    release_date DATE,

    PRIMARY KEY(id)
);

CREATE TABLE books_authors (
    id BIGINT AUTO_INCREMENT,
    book_id BIGINT NOT NULL,
    author_id BIGINT NOT NULL,

    PRIMARY KEY (id),
    FOREIGN KEY (book_id) REFERENCES books (id),
    FOREIGN KEY (author_id) REFERENCES authors (id)
);

INSERT INTO authors
        (id, name, surname)
    VALUES
        (1, 'James', 'Elliott'),
        (2, 'Madhusudhan', 'Konda'),
        (3, 'Timothy', 'Obrian'),
        (4, 'Ryan', 'Fowler');

INSERT INTO books
        (id, title, number_of_pages, has_hard_cover, release_date)
    VALUES
        (1, 'Hibernate: A Developers Notebook', 192, b'1', '2004-05-20'),
        (2, 'Just Hibernate', 140, b'0', '2014-06-10'),
        (3, 'Whats new in Java 7', 19, b'0', '2011-10-20'),
        (4, 'Harnessing Hibernate', 382, b'1', '2008-05-02');

INSERT INTO books_authors
        (book_id, author_id)
    VALUES
        (1, 1),
        (2, 2),
        (3, 2),
        (4, 2),
        (4, 1),
        (4, 3);
