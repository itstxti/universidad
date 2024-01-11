--Para conectarse
--psql -U admin -p 5432 -d postgres
--psql -U cliente -p 5432 -d postgres
--psql -U gestor -p 5432 -d postgres
--psql -U critico -p 5432 -d postgres


--Para ver que los usuarios se han creado correctamente
SELECT * FROM pg_user;

--Para ver con que usuario nos hemos conectado
SELECT current_user;

--PARA VERIFICAR USUARIOS
--INTRODUCCIONES 
INSERT INTO ddbb.personal (nombre_personal, año_nacimiento, año_muerte) VALUES ('Charlotte Wells', 1983, NULL);
INSERT INTO ddbb.criticas (año_pelicula, titulo_pelicula, nombre_critico, puntuacion, texto_critica, pagina_web)
VALUES (1993, 'Posse', 'Karsten Runquist', 9, 'mu buena', 'https://letterboxd.com/kurstboy/film/posse/');

--CONSULTAS
SELECT * FROM ddbb.director LIMIT 5;

--MODIFICACIONES
UPDATE ddbb.personal SET año_muerte = 2023 WHERE nombre_personal = 'Charlotte Wells';

--ELIMINACIONES
DELETE FROM ddbb.personal WHERE nombre_personal = 'Charlotte Wells';
DELETE FROM ddbb.criticas WHERE titulo_pelicula = 'Posse' AND nombre_critico = 'Karsten Runquist';

--TABLAS NUEVAS
CREATE TABLE IF NOT EXISTS ddbb.prueba (
    prueba TEXT,
    CONSTRAINT pk_prueba PRIMARY KEY (prueba)
);

DROP TABLE  IF EXISTS ddbb.prueba;

