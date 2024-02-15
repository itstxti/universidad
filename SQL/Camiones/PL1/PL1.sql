-- "C:\Program Files\PostgreSQL\16\bin\psql.exe" -U postgres
-- \i pl1.sql

BEGIN;

CREATE SCHEMA IF NOT EXISTS PL1;
SET search_path TO PL1;

CREATE TABLE IF NOT EXISTS PL1.camiones(
    id_camion SERIAL,
    matricula VARCHAR(7) UNIQUE,
    empresa TEXT,
    kilometros INT,
    PRIMARY KEY(id_camion)
);

--cargamos los datos del fichero 'camiones.txt' a la tabla
\COPY PL1.camiones(id_camion, matricula, empresa, kilometros) FROM 'camiones.txt' WITH (DELIMITER E',', NULL 'NULL', ENCODING 'UTF-8');

--hacemos el select para comprobar que funciona y ha cargado los datos
SELECT * FROM PL1.camiones;

ROLLBACK;