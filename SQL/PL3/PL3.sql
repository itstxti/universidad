\pset pager off
--DROP SCHEMA IF EXISTS ddbb CASCADE;
--DROP SCHEMA IF EXISTS temporal CASCADE;

--BEGIN;

CREATE SCHEMA IF NOT EXISTS ddbb;
CREATE SCHEMA IF NOT EXISTS temporal;

-- TABLAS TEMPORALES
CREATE TABLE IF NOT EXISTS temporal.actor (
    año_pelicula TEXT,
    titulo_pelicula TEXT,
    nombre TEXT,
    nacimiento TEXT,
    muerte TEXT,
    personaje TEXT
);

CREATE TABLE IF NOT EXISTS temporal.director (
    año_pelicula TEXT,
    titulo_pelicula TEXT,
    nombre TEXT,
    nacimiento TEXT,
    muerte TEXT
);

CREATE TABLE IF NOT EXISTS temporal.peliculas (
    año TEXT,
    titulo TEXT,
    géneros TEXT,
    idioma TEXT,
    duracion TEXT,
    calificacion TEXT
);

CREATE TABLE IF NOT EXISTS temporal.guionista (
    año_pelicula TEXT,
    titulo_pelicula TEXT,
    nombre TEXT,
    nacimiento TEXT,
    muerte TEXT
);

CREATE TABLE IF NOT EXISTS temporal.criticas (
    fecha TEXT,
    titulo_pelicula TEXT,
    critico TEXT,  
    puntuacion TEXT,
    texto TEXT,
    direccion TEXT
);

CREATE TABLE IF NOT EXISTS temporal.caratula (
    año_pelicula TEXT,
    titulo_pelicula TEXT,
    nombre TEXT,
    fecha TEXT,
    direccion TEXT,
    tamaño TEXT
);

-- TABLAS FINALES
CREATE TABLE IF NOT EXISTS ddbb.personal (
    nombre_personal TEXT,
    año_nacimiento INTEGER,
    año_muerte INTEGER, 
    CONSTRAINT personal_pk PRIMARY KEY (nombre_personal)
);

CREATE TABLE IF NOT EXISTS ddbb.actor (
    nombre_actor TEXT,
    CONSTRAINT pk_actor PRIMARY KEY (nombre_actor),
    CONSTRAINT fk_personal FOREIGN KEY (nombre_actor) REFERENCES ddbb.personal(nombre_personal)
);

CREATE TABLE IF NOT EXISTS ddbb.director (
    nombre_director TEXT,
    CONSTRAINT pk_director PRIMARY KEY (nombre_director),
    CONSTRAINT fk_personal FOREIGN KEY (nombre_director) REFERENCES ddbb.personal(nombre_personal)
);

CREATE TABLE IF NOT EXISTS ddbb.guionista (
    nombre_guionista TEXT,
    CONSTRAINT pk_guionista PRIMARY KEY (nombre_guionista),
    CONSTRAINT fk_personal FOREIGN KEY (nombre_guionista) REFERENCES ddbb.personal(nombre_personal)
);

CREATE TABLE IF NOT EXISTS ddbb.peliculas (
    año INTEGER,
    titulo TEXT,
    idioma VARCHAR(2),
    duracion INTEGER,
    calificacion TEXT,
    nombre_director TEXT,
    CONSTRAINT pk_peliculas PRIMARY KEY (año, titulo),
    CONSTRAINT fk_directores FOREIGN KEY (nombre_director) REFERENCES ddbb.director(nombre_director)
);

CREATE TABLE IF NOT EXISTS ddbb.generos (
    genero TEXT, 
    año_pelicula INTEGER,
    titulo_pelicula TEXT,
    CONSTRAINT pk_generos PRIMARY KEY (genero, año_pelicula, titulo_pelicula),
    CONSTRAINT fk_peliculas FOREIGN KEY (año_pelicula, titulo_pelicula) REFERENCES ddbb.peliculas(año, titulo)
);

CREATE TABLE IF NOT EXISTS ddbb.pagina_web (
    pagina_web TEXT,
    CONSTRAINT pk_pagina_web PRIMARY KEY (pagina_web)
);

CREATE TABLE IF NOT EXISTS ddbb.criticas (
    año_pelicula integer,
    titulo_pelicula TEXT,
    nombre_critico TEXT,
    puntuacion numeric(2,1),
    texto_critica TEXT,
    pagina_web TEXT,
    CONSTRAINT pk_criticas PRIMARY KEY (año_pelicula, titulo_pelicula, nombre_critico),
    CONSTRAINT fk_web FOREIGN KEY (pagina_web) REFERENCES ddbb.pagina_web(pagina_web),
    CONSTRAINT fk_peliculas FOREIGN KEY (año_pelicula, titulo_pelicula) REFERENCES ddbb.peliculas(año, titulo)
);

CREATE TABLE IF NOT EXISTS ddbb.caratula (
    nombre_caratula TEXT,
    tamaño TEXT,
    año_pelicula integer,
    titulo_pelicula TEXT,
    pagina_web TEXT,
    CONSTRAINT pk_caratula PRIMARY KEY (nombre_caratula, año_pelicula, titulo_pelicula),
    CONSTRAINT fk_peliculas FOREIGN KEY (año_pelicula, titulo_pelicula) REFERENCES ddbb.peliculas(año, titulo) 
);

CREATE TABLE IF NOT EXISTS ddbb.actuan (
    papel TEXT,
    nombre_actor TEXT,
    año_pelicula integer,
    titulo_pelicula TEXT,
    CONSTRAINT pk_actuan PRIMARY KEY (nombre_actor, año_pelicula, titulo_pelicula),
    CONSTRAINT fk_peliculas FOREIGN KEY (año_pelicula, titulo_pelicula) REFERENCES ddbb.peliculas(año, titulo),
    CONSTRAINT fk_actor FOREIGN KEY (nombre_actor) REFERENCES ddbb.actor(nombre_actor)
);

CREATE TABLE IF NOT EXISTS ddbb.guionizan (
    nombre_guionista TEXT,
    año_pelicula integer,
    titulo_pelicula TEXT,
    CONSTRAINT pk_guionizan PRIMARY KEY (nombre_guionista, año_pelicula, titulo_pelicula),
    CONSTRAINT fk_peliculas FOREIGN KEY (año_pelicula, titulo_pelicula) REFERENCES ddbb.peliculas(año, titulo),
    CONSTRAINT fk_guionista FOREIGN KEY (nombre_guionista) REFERENCES ddbb.guionista(nombre_guionista)
);

CREATE TABLE IF NOT EXISTS ddbb.alojadas (
    fecha timestamp,
    nombre_caratula TEXT,
    año_pelicula integer,
    titulo_pelicula TEXT,
    pagina_web TEXT,
    CONSTRAINT pk_alojadas PRIMARY KEY (nombre_caratula, año_pelicula, titulo_pelicula, pagina_web),
    CONSTRAINT fk_caratulas FOREIGN KEY (nombre_caratula, año_pelicula, titulo_pelicula) REFERENCES ddbb.caratula(nombre_caratula,
    año_pelicula, titulo_pelicula),
    CONSTRAINT fk_pagina_web FOREIGN KEY (pagina_web) REFERENCES ddbb.pagina_web(pagina_web)
);

-- INSERTAR DATOS EN TABLAS TEMPORALES.
\COPY temporal.director(año_pelicula, titulo_pelicula, nombre, nacimiento, muerte) FROM 'directores_peliculas.csv' WITH (FORMAT csv, HEADER false, DELIMITER E'\t', NULL 'NULL', ENCODING 'UTF-8');

\COPY temporal.peliculas FROM 'peliculas.csv' WITH (FORMAT csv, HEADER false, DELIMITER E'\t', NULL 'NULL', ENCODING 'UTF-8');

\COPY temporal.actor(año_pelicula, titulo_pelicula, nombre, nacimiento, muerte, personaje) FROM 'actores_peliculas.csv' WITH (FORMAT csv, HEADER false, DELIMITER E'\t', NULL 'NULL', ENCODING 'UTF-8');

\COPY temporal.guionista(año_pelicula, titulo_pelicula, nombre, nacimiento, muerte) FROM 'guionistas_peliculas.csv' WITH (FORMAT csv, HEADER false, DELIMITER E'\t', NULL 'NULL', ENCODING 'UTF-8');

\COPY temporal.caratula(año_pelicula, titulo_pelicula, nombre, fecha, direccion, tamaño) FROM 'caratulas.csv' WITH (FORMAT csv, HEADER false, DELIMITER E'\t', NULL 'NULL', ENCODING 'UTF-8');

\COPY temporal.criticas(fecha, titulo_pelicula, critico, puntuacion, texto, direccion) FROM 'criticas.csv' WITH (FORMAT csv, HEADER false, DELIMITER E'\t', NULL 'NULL', ENCODING 'UTF-8');

-- INSERTAR DATOS DE LAS TABLAS TEMPORALES A LAS FINALES.
INSERT INTO ddbb.personal (nombre_personal, año_nacimiento, año_muerte)
SELECT 
    nombre,
    CAST(NULLIF(nacimiento, '\N') AS INTEGER),
    CAST(NULLIF(muerte, '\N') AS INTEGER)
FROM temporal.director
ON CONFLICT (nombre_personal) DO NOTHING;

INSERT INTO ddbb.personal (nombre_personal, año_nacimiento, año_muerte) 
SELECT 
    nombre,
    CAST(NULLIF(nacimiento, '\N') AS INTEGER),
    CAST(NULLIF(muerte, '\N') AS INTEGER)
FROM temporal.actor
ON CONFLICT (nombre_personal) DO NOTHING;

INSERT INTO ddbb.personal (nombre_personal, año_nacimiento, año_muerte) 
SELECT 
    nombre,
    CAST(NULLIF(nacimiento, '\N') AS INTEGER),
    CAST(NULLIF(muerte, '\N') AS INTEGER)
FROM temporal.guionista ON CONFLICT (nombre_personal) DO NOTHING;

INSERT INTO ddbb.director (nombre_director)
SELECT 
    nombre
FROM temporal.director;

INSERT INTO ddbb.actor (nombre_actor)
SELECT 
    nombre
FROM temporal.actor
ON CONFLICT (nombre_actor) DO NOTHING;

INSERT INTO ddbb.guionista (nombre_guionista)
SELECT 
    nombre
FROM temporal.guionista;

INSERT INTO ddbb.peliculas (año, titulo, idioma, duracion, calificacion, nombre_director)
SELECT 
    CAST(NULLIF(año, '\N') AS INTEGER) AS año,
    titulo,
    idioma,
    CAST(NULLIF(SPLIT_PART(CAST(duracion AS TEXT), ' ', 1), '\N') AS INTEGER),
    calificacion,
    nombre
FROM temporal.peliculas JOIN temporal.director
ON temporal.peliculas.año = temporal.director.año_pelicula AND temporal.peliculas.titulo = temporal.director.titulo_pelicula
ON CONFLICT (año, titulo) DO NOTHING;





INSERT INTO ddbb.generos (genero, año_pelicula, titulo_pelicula)
SELECT
    géneros,
    CAST(NULLIF(temporal.peliculas.año, '\N') AS INTEGER),
    temporal.peliculas.titulo
FROM temporal.peliculas 
JOIN ddbb.peliculas 
    ON CAST(temporal.peliculas.año AS INTEGER) = ddbb.peliculas.año AND temporal.peliculas.titulo = ddbb.peliculas.titulo;

INSERT INTO ddbb.actuan (papel, nombre_actor, año_pelicula, titulo_pelicula)
SELECT 
    personaje, 
    nombre,
    CAST(NULLIF(temporal.actor.año_pelicula, '\N') AS INTEGER),
    titulo_pelicula
FROM temporal.actor JOIN ddbb.peliculas 
ON CAST(temporal.actor.año_pelicula AS INTEGER) = ddbb.peliculas.año AND temporal.actor.titulo_pelicula = ddbb.peliculas.titulo;

INSERT INTO ddbb.guionizan (nombre_guionista, año_pelicula, titulo_pelicula)
SELECT 
    nombre,
    CAST(NULLIF(temporal.guionista.año_pelicula, '\N') AS INTEGER),
    titulo_pelicula
FROM temporal.guionista JOIN ddbb.peliculas
ON CAST(temporal.guionista.año_pelicula AS INTEGER) = ddbb.peliculas.año AND temporal.guionista.titulo_pelicula = ddbb.peliculas.titulo;

INSERT INTO ddbb.pagina_web (pagina_web)
SELECT
    direccion
FROM temporal.criticas JOIN ddbb.peliculas ON criticas.titulo_pelicula = peliculas.titulo
ON CONFLICT (pagina_web) DO NOTHING;

INSERT INTO ddbb.pagina_web (pagina_web)
SELECT
    direccion
FROM temporal.caratula JOIN ddbb.peliculas ON caratula.titulo_pelicula = peliculas.titulo
ON CONFLICT (pagina_web) DO NOTHING;

INSERT INTO ddbb.criticas (año_pelicula, titulo_pelicula, nombre_critico, puntuacion, texto_critica, pagina_web)
SELECT 
    peliculas.año,
    temporal.criticas.titulo_pelicula,
    temporal.criticas.critico, 
    CAST(temporal.criticas.puntuacion AS numeric(2,1)),
    temporal.criticas.texto,
    temporal.criticas.direccion
FROM temporal.criticas
JOIN ddbb.peliculas ON temporal.criticas.titulo_pelicula = peliculas.titulo
ON CONFLICT (año_pelicula, titulo_pelicula, nombre_critico) DO NOTHING;

INSERT INTO ddbb.caratula(nombre_caratula, tamaño, año_pelicula, titulo_pelicula, pagina_web)
SELECT
    nombre,
    tamaño,
    CAST(temporal.caratula.año_pelicula AS INTEGER),
    temporal.caratula.titulo_pelicula,
    temporal.caratula.direccion
FROM temporal.caratula
JOIN ddbb.peliculas ON temporal.caratula.titulo_pelicula = peliculas.titulo
ON CONFLICT (nombre_caratula, año_pelicula, titulo_pelicula) DO NOTHING;

INSERT INTO ddbb.alojadas(fecha, nombre_caratula, año_pelicula, titulo_pelicula, pagina_web)
SELECT
    CASE WHEN fecha = '\N' THEN NULL ELSE TO_TIMESTAMP(fecha, 'YYYY-MM-DD HH24:MI:SS') END,
    nombre,
    CAST(NULLIF(temporal.caratula.año_pelicula, '\N') AS INTEGER),
    temporal.caratula.titulo_pelicula,
    criticas.pagina_web
FROM temporal.caratula 
JOIN ddbb.criticas ON temporal.caratula.titulo_pelicula = criticas.titulo_pelicula
ON CONFLICT (nombre_caratula, año_pelicula, titulo_pelicula, pagina_web) DO NOTHING;

-- CONSULTAS

--Mostrar el nombre de los directores nacidos en 1970.
SELECT nombre_director FROM ddbb.director WHERE nombre_director IN (SELECT nombre_personal FROM ddbb.personal WHERE año_nacimiento = '1970');

-- Mostrar todos los idiomas de las películas junto al número de películas que hay en ese idioma.
--La salida debe de estar ordenada del idioma con más películas al que tiene menos.

SELECT idioma, COUNT(*) AS numero_peliculas
FROM ddbb.peliculas
GROUP BY idioma
ORDER BY numero_peliculas DESC;

--Mostrar el nombre del actor o actores más jóvenes junto a su año de nacimiento.

SELECT nombre_actor, año_nacimiento
FROM ddbb.actor
JOIN ddbb.personal ON actor.nombre_actor = personal.nombre_personal
WHERE año_nacimiento IS NOT NULL
ORDER BY año_nacimiento DESC
LIMIT 1;

--Mostrar el nombre de los actores que aparezcan en más de una película junto con el número de películas en las cuales ha actuado.

SELECT nombre_actor, COUNT(*) AS numero_peliculas
FROM ddbb.actuan
GROUP BY nombre_actor
HAVING COUNT(*) > 1;

-- Mostrar un listado de géneros con la cantidad de películas pertenecientes al mismo, ordenados por los que tienen más películas a los que tienen menos.

SELECT genero, COUNT(*) AS cantidad_peliculas
FROM ddbb.generos
GROUP BY genero
ORDER BY cantidad_peliculas DESC;

-- Mostrar el nombre de todos guionistas que han trabajado en películas de género de deportes y cine negro.

SELECT g.nombre_guionista
FROM ddbb.guionista g
JOIN ddbb.guionizan gu ON g.nombre_guionista = gu.nombre_guionista
JOIN ddbb.peliculas p ON gu.año_pelicula = p.año AND gu.titulo_pelicula = p.titulo
JOIN ddbb.generos gen ON p.año = gen.año_pelicula AND p.titulo = gen.titulo_pelicula
WHERE gen.genero LIKE '%Sports%'
  OR gen.genero LIKE '%Crime%';

-- Solicitar los actores que hayan actuado en películas en idioma japonés
-- con duración inferior a 100 minutos y cuyo año de nacimiento sea inferior a 1960.

SELECT a.nombre_actor
FROM ddbb.actor a
JOIN ddbb.personal per ON a.nombre_actor = per.nombre_personal
JOIN ddbb.actuan act ON a.nombre_actor = act.nombre_actor
JOIN ddbb.peliculas p ON act.año_pelicula = p.año AND act.titulo_pelicula = p.titulo
WHERE p.idioma = 'ja'
  AND per.año_nacimiento < 1960
  AND p.duracion < 100;


-- Mostrar la información de las películas que cuentan con al menos 2 carátulas.
-- La salida será: Título, año de lanzamiento, idioma, duración, calificación y número que carátulas que tiene.

SELECT p.titulo, p.año, p.idioma, p.duracion, p.calificacion, COUNT(c.nombre_caratula) AS num_caratulas
FROM ddbb.peliculas p
JOIN ddbb.caratula c ON p.año = c.año_pelicula AND p.titulo = c.titulo_pelicula
GROUP BY p.titulo, p.año, p.idioma, p.duracion, p.calificacion
HAVING COUNT(c.nombre_caratula) >= 2;


-- Mostrar el título y año de lanzamiento de las 3 películas con mayor puntuación media de entre todas las críticas. Mostrar también dicha puntuación media.

SELECT p.titulo, p.año, AVG(c.puntuacion) AS puntuacion_media
FROM ddbb.peliculas p
JOIN ddbb.criticas c ON p.año = c.año_pelicula AND p.titulo = c.titulo_pelicula
GROUP BY p.titulo, p.año
ORDER BY puntuacion_media DESC
LIMIT 3;

-- Determinar el género o géneros cuyas películas tengan una puntuación media más baja. Mostrar también dicha puntuación media.
SELECT g.genero, AVG(c.puntuacion) AS puntuacion_media
FROM ddbb.generos g
JOIN ddbb.criticas c ON g.año_pelicula = c.año_pelicula AND g.titulo_pelicula = c.titulo_pelicula
GROUP BY g.genero
ORDER BY puntuacion_media ASC
LIMIT 1;

COMMIT;
