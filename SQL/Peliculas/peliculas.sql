-- Comando para iniciar el terminal de PostgreSQL
-- psql -U postgres -p 5432

--DROP SCHEMA IF EXISTS ddbb CASCADE

\pset pager off
BEGIN;

-- Creamos el esquema
CREATE SCHEMA IF NOT EXISTS ddbb;
SET search_path TO ddbb;

-- Creamos la tabla Pelicula
CREATE TABLE IF NOT EXISTS ddbb.pelicula (
    anyo INT,
    titulo VARCHAR,
    generos VARCHAR,
    puntuacion FLOAT,
    duracion VARCHAR,
    idioma VARCHAR,
    calificacion VARCHAR,
    id SERIAL PRIMARY KEY
);

-- Creamos la tabla Critica
CREATE TABLE IF NOT EXISTS ddbb.critica (
    critico VARCHAR PRIMARY KEY,
    puntuacion FLOAT,
    texto VARCHAR,
    fecha DATE
);

CREATE TABLE IF NOT EXISTS ddbb.caratula (
    id_pelicula INT PRIMARY KEY,
    tamano INT,
    fecha DATE,
    FOREIGN KEY (id_pelicula) REFERENCES ddbb.pelicula(id)
);


-- Creamos la tabla Web
CREATE TABLE IF NOT EXISTS ddbb.web (
    direccion VARCHAR PRIMARY KEY,
    tipo VARCHAR
);

-- Creamos la tabla Personal
CREATE TABLE IF NOT EXISTS ddbb.personal (
    id INT PRIMARY KEY,
    nombre VARCHAR,
    nacimiento DATE,
    muerte DATE
);

-- Creamos la tabla Actor
CREATE TABLE IF NOT EXISTS ddbb.actor (
    id_actor INT PRIMARY KEY,
    FOREIGN KEY (id_actor) REFERENCES ddbb.personal(id)
);

-- Creamos la tabla Director
CREATE TABLE IF NOT EXISTS ddbb.director (
    id_director INT PRIMARY KEY,
    FOREIGN KEY (id_director) REFERENCES ddbb.personal(id)
);

-- Creamos la tabla Guionista
CREATE TABLE IF NOT EXISTS ddbb.guionista (
    id_guionista INT PRIMARY KEY,
    FOREIGN KEY (id_guionista) REFERENCES ddbb.personal(id)
);

-- Creamos la tabla Actua, que relaciona Pelicula con Actor
CREATE TABLE IF NOT EXISTS ddbb.actua (
    personaje VARCHAR,
    id_pelicula INT,
    id_id_actor INT,
    PRIMARY KEY(personaje, id_pelicula, id_id_actor),
    FOREIGN KEY(id_pelicula) REFERENCES ddbb.pelicula(id),
    FOREIGN KEY(id_id_actor) REFERENCES ddbb.actor(id_actor)
);


-- Creamos la tabla Dirige, que relaciona Pelicula con Director
CREATE TABLE IF NOT EXISTS ddbb.dirige (
    id_pelicula INT,
    id_id_director INT,
    PRIMARY KEY(id_pelicula, id_id_director),
    FOREIGN KEY(id_pelicula) REFERENCES ddbb.pelicula(id),
    FOREIGN KEY(id_id_director) REFERENCES ddbb.director(id_director)
);


-- Creamos la tabla Escribe, que relaciona Pelicula con Guionista
CREATE TABLE IF NOT EXISTS ddbb.escribe (
    id_pelicula INT,
    id_id_guionista INT,
    PRIMARY KEY(id_pelicula, id_id_guionista),
    FOREIGN KEY(id_pelicula) REFERENCES ddbb.pelicula(id),
    FOREIGN KEY(id_id_guionista) REFERENCES ddbb.guionista(id_guionista)
);

-- Cargamos el archivo 'peliculas.csv' en la tabla Pelicula
\COPY ddbb.pelicula(anyo, titulo, generos, puntuacion, duracion, idioma, calificacion) FROM 'peliculas.csv' WITH (FORMAT csv, HEADER, DELIMITER E',', NULL 'NULL', ENCODING 'UTF-8');

-- Mostramos la tabla Pelicula con los archivos cargados
SELECT * FROM ddbb.pelicula;

-- Rollback al final para permitir la ejecución múltiple
ROLLBACK;
