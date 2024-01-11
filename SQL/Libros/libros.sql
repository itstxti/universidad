-- libros , isbn text, titulo text, autor_id integer, genero text, anio_publicacion integer.
-- autores , autor_id integer, nombre_autor text, nacionalidad text.

CREATE TABLE IF NOT EXISTS autores(
autor_id INTEGER NOT NULL,
nombre_autor TEXT NOT NULL,
nacionalidad TEXT NOT NULL,
CONSTRAINT pk_autores PRIMARY KEY(autor_id)
);

\copy autores FROM './csv/autores.csv' DELIMITER ',' CSV HEADER;
SELECT * FROM autores;

CREATE TABLE IF NOT EXISTS libros(
isbn TEXT NOT NULL,
titulo TEXT NOT NULL,
autor_id INTEGER NOT NULL,
genero TEXT NOT NULL,
anio_publicacion INTEGER NOT NULL,
CONSTRAINT pk_libros PRIMARY KEY(isbn),
CONSTRAINT fk_autores FOREIGN KEY(autor_id) REFERENCES autores(autor_id)
);

\copy libros FROM './csv/libros.csv' DELIMITER ',' CSV HEADER;

SELECT * FROM libros;