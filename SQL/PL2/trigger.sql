
/*DROP TABLE auditoria;
DROP TRIGGER tg_auditoria_personal ON ddbb.personal;
DROP TRIGGER tg_auditoria_actor ON ddbb.actor;
DROP TRIGGER tg_auditoria_director ON ddbb.director;
DROP TRIGGER tg_auditoria_guionista ON ddbb.guionista;
DROP TRIGGER tg_auditoria_peliculas ON ddbb.peliculas;
DROP TRIGGER tg_auditoria_generos ON ddbb.generos;
DROP TRIGGER tg_auditoria_pagina_web ON ddbb.pagina_web;
DROP TRIGGER tg_auditoria_criticas ON ddbb.criticas;
DROP TRIGGER tg_auditoria_caratula ON ddbb.caratula;
DROP TRIGGER tg_auditoria_actuan ON ddbb.actuan;
DROP TRIGGER tg_auditoria_guionizan ON ddbb.guionizan;
DROP TRIGGER tg_auditoria_alojadas ON ddbb.alojadas;
DROP TRIGGER tg_before_insert_caratula ON ddbb.caratula;
DROP TRIGGER tg_before_insert_criticas ON ddbb.criticas;
DROP TRIGGER tg_actualizar_puntuacion_media ON ddbb.criticas;
*/


CREATE TABLE auditoria (
  tabla TEXT,
  accion TEXT,
  usuario TEXT,
  fecha TIMESTAMP	 
);

CREATE TABLE IF NOT EXISTS ddbb.puntuacion_media (
    año_pelicula INTEGER,
    titulo_pelicula TEXT,
    puntuacion_media NUMERIC(3, 2),
    PRIMARY KEY (año_pelicula, titulo_pelicula),
    CONSTRAINT fk_peliculas FOREIGN KEY (año_pelicula, titulo_pelicula) REFERENCES ddbb.peliculas(año, titulo)
);

INSERT INTO ddbb.puntuacion_media (año_pelicula, titulo_pelicula, puntuacion_media)
SELECT
    año_pelicula,
    titulo_pelicula,
    AVG(puntuacion) AS puntuacion_media
FROM ddbb.criticas
GROUP BY año_pelicula, titulo_pelicula
ON CONFLICT (año_pelicula, titulo_pelicula) DO UPDATE
SET puntuacion_media = EXCLUDED.puntuacion_media;

CREATE OR REPLACE FUNCTION fn_auditoria() RETURNS TRIGGER AS $fn_auditoria$
BEGIN
  IF TG_OP = 'INSERT' THEN
    INSERT INTO auditoria (tabla, accion, usuario, fecha) VALUES (TG_TABLE_NAME, 'alta', SESSION_USER, CURRENT_TIMESTAMP);
  ELSIF TG_OP = 'UPDATE' THEN
    INSERT INTO auditoria (tabla, accion, usuario, fecha) VALUES (TG_TABLE_NAME, 'modificación', SESSION_USER, CURRENT_TIMESTAMP);
  ELSIF TG_OP = 'DELETE' THEN
    INSERT INTO auditoria (tabla, accion, usuario, fecha) VALUES (TG_TABLE_NAME, 'borrado', SESSION_USER, CURRENT_TIMESTAMP);
  END IF;
  RETURN NULL;
END;
$fn_auditoria$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION trg_before_insert_caratula()
RETURNS TRIGGER AS $trg_before_insert_caratula$
BEGIN
  -- Verifica si la página web existe
  IF NOT EXISTS (SELECT 1 FROM ddbb.pagina_web WHERE pagina_web = NEW.pagina_web) THEN
    -- Si no existe, inserta la página web
    INSERT INTO ddbb.pagina_web (pagina_web) VALUES (NEW.pagina_web);
  END IF;
  
  RETURN NEW;
END;
$trg_before_insert_caratula$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION trg_before_insert_criticas()
RETURNS TRIGGER AS $trg_before_insert_criticas$
BEGIN
  -- Verifica si la página web existe
  IF NOT EXISTS (SELECT 1 FROM ddbb.pagina_web WHERE pagina_web = NEW.pagina_web) THEN
    -- Si no existe, inserta la página web
    INSERT INTO ddbb.pagina_web (pagina_web) VALUES (NEW.pagina_web);
  END IF;
  
  RETURN NEW;
END;
$trg_before_insert_criticas$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION fn_actualizar_puntuacion_media()
RETURNS TRIGGER AS $fn_actualizar_puntuacion_media$
DECLARE
    puntuacion_media NUMERIC(3, 2);
BEGIN
    -- Check if NEW record has null values for año_pelicula or titulo_pelicula
    IF NEW.año_pelicula IS NULL OR NEW.titulo_pelicula IS NULL THEN
        RETURN NEW;
    END IF;

    -- Calculate the new average rating
    SELECT AVG(c.puntuacion) INTO puntuacion_media
    FROM ddbb.criticas c
    WHERE c.año_pelicula = NEW.año_pelicula AND c.titulo_pelicula = NEW.titulo_pelicula;

    -- Insert or update the average rating in the puntuacion_media table
    INSERT INTO ddbb.puntuacion_media (año_pelicula, titulo_pelicula, puntuacion_media)
    VALUES (NEW.año_pelicula, NEW.titulo_pelicula, puntuacion_media)
    ON CONFLICT (año_pelicula, titulo_pelicula) DO UPDATE
    SET puntuacion_media = EXCLUDED.puntuacion_media;

    RETURN NEW;
END;
$fn_actualizar_puntuacion_media$ LANGUAGE plpgsql;


-- Crea el trigger para la tabla de críticas
CREATE TRIGGER tg_actualizar_puntuacion_media
AFTER INSERT OR UPDATE
ON ddbb.criticas
FOR EACH ROW
EXECUTE FUNCTION fn_actualizar_puntuacion_media();



-- Tabla personal
CREATE TRIGGER tg_auditoria_personal
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.personal FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla actor
CREATE TRIGGER tg_auditoria_actor
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.actor FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla director
CREATE TRIGGER tg_auditoria_director
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.director FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla guionista
CREATE TRIGGER tg_auditoria_guionista
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.guionista FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla peliculas
CREATE TRIGGER tg_auditoria_peliculas
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.peliculas FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla generos
CREATE TRIGGER tg_auditoria_generos
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.generos FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla pagina_web
CREATE TRIGGER tg_auditoria_pagina_web
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.pagina_web FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla criticas
CREATE TRIGGER tg_auditoria_criticas
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.criticas FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla caratula
CREATE TRIGGER tg_auditoria_caratula
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.caratula FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla actuan
CREATE TRIGGER tg_auditoria_actuan
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.actuan FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla guionizan
CREATE TRIGGER tg_auditoria_guionizan
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.guionizan FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();

-- Tabla alojadas
CREATE TRIGGER tg_auditoria_alojadas
AFTER INSERT OR UPDATE OR DELETE
ON ddbb.alojadas FOR EACH ROW
EXECUTE PROCEDURE fn_auditoria();


CREATE TRIGGER tg_before_insert_caratula
BEFORE INSERT ON ddbb.caratula
FOR EACH ROW
EXECUTE FUNCTION trg_before_insert_caratula();

CREATE TRIGGER tg_before_insert_criticas
BEFORE INSERT ON ddbb.criticas
FOR EACH ROW
EXECUTE FUNCTION trg_before_insert_criticas();