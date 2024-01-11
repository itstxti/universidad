CREATE TABLE IF NOT EXISTS fabricante(
codigo INTEGER NOT NULL,
nombre TEXT NOT NULL,
CONSTRAINT pk_fabricante PRIMARY KEY(codigo)
);

\copy fabricante FROM './csv/fabricante.csv' DELIMITER ',' CSV HEADER;

SELECT * FROM fabricante;

CREATE TABLE producto(
codigo INTEGER NOT NULL,
nombre TEXT NOT NULL,
precio DOUBLE PRECISION NOT NULL,
codigo_fabricante INTEGER NOT NULL,
CONSTRAINT pk_producto PRIMARY KEY(codigo),
CONSTRAINT fk_fabricante FOREIGN KEY(codigo_fabricante) REFERENCES fabricante(codigo)
);

\copy producto FROM './csv/producto.csv' DELIMITER ',' CSV HEADER;

SELECT * FROM producto;