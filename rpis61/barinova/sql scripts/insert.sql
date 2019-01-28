INSERT INTO readers(first_name, second_name, birth_date)
VALUES ("Ye", "Vaar", '1996-07-18');

INSERT INTO authors(first_name, second_name, birth_date)
VALUES ("Nika", "Wodwood", '1990-03-18');

INSERT INTO books(book_name, description, print_year)
VALUES ("пёся", "комиксы про пёсю", 2016);

INSERT INTO genres(genre, description)
VALUES ("novel", "novel");

INSERT INTO books_authors(authors_id,books_id)
VALUES (1,1);

INSERT INTO books_genres(books_id, genres_id)
VALUES (1,1);
