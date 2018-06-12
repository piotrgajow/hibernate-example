DROP TABLE IF EXISTS books;
DROP TABLE IF EXISTS authors;

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
    author_id BIGINT NOT NULL,

    PRIMARY KEY(id),
    FOREIGN KEY (author_id) REFERENCES authors (id)
);

INSERT INTO authors
        (id, name, surname)
    VALUES
        (1, 'James', 'Elliott'),
        (2, 'Madhusudhan', 'Konda');

INSERT INTO books
        (title, number_of_pages, has_hard_cover, release_date, author_id)
    VALUES
        ('Hibernate: A Developers Notebook', 192, b'1', '2004-05-20', 1),
        ('Just Hibernate', 140, b'0', '2014-06-10', 2);
