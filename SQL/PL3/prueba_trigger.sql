--INSERCION
INSERT INTO ddbb.personal (nombre_personal, año_nacimiento, año_muerte) VALUES ('Paul Mescal', 1996, NULL);
INSERT INTO ddbb.personal (nombre_personal, año_nacimiento, año_muerte) VALUES ('Charlotte Wells', 1983, NULL);
INSERT INTO ddbb.director (nombre_director) VALUES ('Charlotte Wells');
INSERT INTO ddbb.peliculas (año, titulo, idioma, duracion, calificacion, nombre_director)
VALUES (2022, 'Aftersun', 'en', 120, NULL, 'Charlotte Wells');

--introducimos una critica
INSERT INTO ddbb.criticas (año_pelicula, titulo_pelicula, nombre_critico, puntuacion, texto_critica, pagina_web)
VALUES (2022, 'Aftersun', 'Karsten Runquist', 9, 'might have shed a few tears but you didnt hear that from me', 'https://letterboxd.com/kurstboy/film/aftersun/');

--comprobamos si se se añadio a la tabla de la puntuacion media
SELECT * FROM ddbb.puntuacion_media WHERE titulo_pelicula = 'Aftersun';

--introducimos otra critica
INSERT INTO ddbb.criticas (año_pelicula, titulo_pelicula, nombre_critico, puntuacion, texto_critica, pagina_web)
VALUES (2022, 'Aftersun', 'Tati', 9.5, 'very sad', 'https://letterboxd.com/tobiosoft/film/aftersun/');

--comprobamos que se ha actualizado la tabla de la puntuacion media
SELECT * FROM ddbb.puntuacion_media WHERE titulo_pelicula = 'Aftersun';

--introducimos una caratula
INSERT INTO ddbb.caratula (nombre_caratula, tamaño, año_pelicula, titulo_pelicula, pagina_web)
VALUES ('aftersun-2022', 'Poster', 2022, 'Aftersun', 'https://www.covercaratulas.com/amp/caratula-carteles-aftersun-48795.html');

--comprobamos si las nuevas paginas web se han añadido a su tabla
SELECT * FROM ddbb.pagina_web WHERE pagina_web = 'https://letterboxd.com/kurstboy/film/aftersun/';
SELECT * FROM ddbb.pagina_web WHERE pagina_web = 'https://letterboxd.com/tobiosoft/film/aftersun/';
SELECT * FROM ddbb.pagina_web WHERE pagina_web = 'https://www.covercaratulas.com/amp/caratula-carteles-aftersun-48795.html';



--MODIFICACION
UPDATE ddbb.personal SET año_muerte = 2023 WHERE nombre_personal = 'Paul Mescal';
UPDATE ddbb.peliculas SET duracion = 150, calificacion = 'PG-13' WHERE año = 2022 AND titulo = 'Aftersun';
UPDATE ddbb.criticas SET puntuacion = 8 WHERE año_pelicula = 2022 AND titulo_pelicula = 'Aftersun' AND nombre_critico = 'Karsten Runquist';

--comprobamos que se ha actualizado la tabla de la puntuacion media
SELECT * FROM ddbb.puntuacion_media WHERE titulo_pelicula = 'Aftersun';

--ELIMINACIÓN
DELETE FROM ddbb.puntuacion_media WHERE titulo_pelicula = 'Aftersun';
DELETE FROM ddbb.personal WHERE nombre_personal = 'Paul Mescal';
DELETE FROM ddbb.criticas WHERE titulo_pelicula = 'Aftersun';
DELETE FROM ddbb.pagina_web WHERE pagina_web = 'https://letterboxd.com/kurstboy/film/aftersun/';
DELETE FROM ddbb.pagina_web WHERE pagina_web = 'https://letterboxd.com/tobiosoft/film/aftersun/';
DELETE FROM ddbb.pagina_web WHERE pagina_web = 'https://www.covercaratulas.com/amp/caratula-carteles-aftersun-48795.html';


DELETE FROM ddbb.caratula WHERE titulo_pelicula = 'Aftersun';
DELETE FROM ddbb.peliculas WHERE titulo = 'Aftersun';
DELETE FROM ddbb.director WHERE nombre_director = 'Charlotte Wells';
DELETE FROM ddbb.personal WHERE nombre_personal = 'Charlotte Wells';

--Se comprueba que los trigger de auditoria ha funcionado bien.
SELECT * FROM ddbb.auditoria;
