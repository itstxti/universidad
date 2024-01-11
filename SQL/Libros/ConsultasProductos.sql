--1. Lista el nombre de todos los productos que hay en la tabla producto.
SELECT nombre FROM producto;

--2. Lista los nombres y los precios de todos los productos de la tabla producto.
SELECT nombre, precio FROM producto;

-- 3. Lista todas las columnas de la tabla producto.
SELECT * FROM producto;

-- 4. Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD).
SELECT nombre, precio as precio_euros,precio *1.2 as precio_dolares FROM producto; 

-- 5. Lista el nombre de los productos, el precio en euros y el precio en dólares estadounidenses (USD). Utiliza los siguientes alias para las columnas: nombre de producto, euros, dólares.
SELECT nombre as "nombre de producto",precio as euros, precio as "dólares" FROM producto;

-- 6. Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a mayúscula.
SELECT UPPER(nombre) AS "Nombre mayus" , precio FROM PRODUCTO;

-- 7. Lista los nombres y los precios de todos los productos de la tabla producto, convirtiendo los nombres a minúscula.
SELECT LOWER (NOMBRE) AS "nombreminus", precio FROM PRODUCTO;

-- 8. Lista el nombre de todos los fabricantes en una columna, y en otra columna obtenga en mayúsculas los dos primeros caracteres del nombre del fabricante.
SELECT nombre, UPPER (substring(nombre,1,2)) FROM PRODUCTO;

-- 9. Lista los nombres y los precios de todos los productos de la tabla producto, redondeando el valor del precio.
SELECT nombre, ROUND (precio) FROM producto;

-- 10. Lista los nombres y los precios de todos los productos de la tabla producto, truncando el valor del precio para mostrarlo sin ninguna cifra decimal.
SELECT nombre, TRUNCATE (precio,0) FROM producto;

-- 11. Lista el identificador de los fabricantes que tienen productos en la tabla producto.
SELECT codigo_fabricante FROM producto;

-- 12. Lista el identificador de los fabricantes que tienen productos en la tabla producto, eliminando los identificadores que aparecen repetidos.
SELECT DISTINCT codigo_fabricante FROM producto;

-- 13. Lista los nombres de los fabricantes ordenados de forma ascendente.
SELECT nombre FROM fabricante ORDER BY nombre ASC;

-- 14. Lista los nombres de los fabricantes ordenados de forma descendente.
SELECT nombre FROM fabricante ORDER BY nombre DESC;

-- 15. Lista los nombres de los productos ordenados en primer lugar por el nombre de forma ascendente y en segundo lugar por el precio de forma descendente.
SELECT nombre,precio FROM producto ORDER BY nombre ASC,precio DESC;

-- 16. Devuelve una lista con las 5 primeras filas de la tabla fabricante.
SELECT * FROM fabricante LIMIT 5;

-- 17. Devuelve una lista con 2 filas a partir de la cuarta fila de la tabla fabricante. La cuarta fila también se debe incluir en la respuesta.
SELECT * FROM fabricante LIMIT 2 OFFSET 3;

-- 18. Lista el nombre y el precio del producto más barato. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT nombre,precio FROM producto ORDER BY precio ASC LIMIT 1;

-- 19. Lista el nombre y el precio del producto más caro. (Utilice solamente las cláusulas ORDER BY y LIMIT)
SELECT nombre,precio FROM producto ORDER BY precio DESC LIMIT 1;

-- 20. Lista el nombre de todos los productos del fabricante cuyo identificador de fabricante es igual a 2.
SELECT nombre FROM producto WHERE codigo_fabricante = 2;

-- 21. Lista el nombre de los productos que tienen un precio menor o igual a 120€.
SELECT nombre,precio FROM producto WHERE precio <=120;

-- 22. Lista el nombre de los productos que tienen un precio mayor o igual a 400€.
SELECT nombre FROM producto where precio >=400;

-- 23. Lista el nombre de los productos que no tienen un precio mayor o igual a 400€.
SELECT nombre FROM producto where precio <400;

-- 24. Lista todos los productos que tengan un precio entre 80€ y 300€. Sin utilizar el operador BETWEEN.
SELECT precio FROM producto WHERE precio >80 AND precio <300;

-- 25. Lista todos los productos que tengan un precio entre 60€ y 200€. Utilizando el operador BETWEEN.
SELECT precio FROM producto WHERE precio BETWEEN 60 AND 200;

-- 26. Lista todos los productos que tengan un precio mayor que 200€ y que el identificador de fabricante sea igual a 6.
SELECT * FROM producto WHERE precio >200 AND codigo_fabricante=6;

-- 27. Lista todos los productos donde el identificador de fabricante sea 1, 3 o 5. Sin utilizar el operador IN.
SELECT nombre FROM producto WHERE codigo_fabricante = 1 OR codigo_fabricante = 3 OR codigo_fabricante = 5;

-- 28. Lista todos los productos donde el identificador de fabricante sea 1, 3 o 5. Utilizando el operador IN.
SELECT nombre FROM producto WHERE codigo_fabricante IN (1,3,5);

-- 29. Lista el nombre y el precio de los productos en céntimos (Habrá que multiplicar por 100 el valor del precio). Cree un alias para la columna que contiene el precio que se llame céntimos.
SELECT nombre, precio, precio *100 as "precio en centimos" FROM producto;

-- 30. Lista los nombres de los fabricantes cuyo nombre empiece por la letra S.
SELECT nombre FROM fabricante WHERE nombre LIKE 'S%';

-- 31. Lista los nombres de los fabricantes cuyo nombre termine por la vocal e.
SELECT nombre FROM fabricante WHERE nombre LIKE '%e';

-- 32. Lista los nombres de los fabricantes cuyo nombre contenga el carácter w.
SELECT nombre FROM fabricante WHERE nombre LIKE '%w%';

-- 33. Lista los nombres de los fabricantes cuyo nombre sea de 4 caracteres.
SELECT nombre FROM fabricante WHERE LENGTH (nombre)=4;

-- 34. Devuelve una lista con el nombre de todos los productos que contienen la cadena Portátil en el nombre.
SELECT nombre FROM producto WHERE nombre LIKE '%Portátil%';

-- 35. Devuelve una lista con el nombre de todos los productos que contienen la cadena Monitor en el nombre y tienen un precio inferior a 215 €.
SELECT nombre FROM producto WHERE nombre LIKE '%Monitor%' AND precio <215;

-- 36. Lista el nombre y el precio de todos los productos que tengan un precio mayor o igual a 180€. Ordene el resultado en primer lugar por el precio
-- (en orden descendente) y en segundo lugar por el nombre (en orden ascendente).
SELECT nombre, precio FROM producto WHERE precio >= 180 ORDER BY precio DESC, nombre ASC;

-- 37. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos.
SELECT p.nombre AS "nombre producto", p.precio AS "precio producto", f.nombre AS "nombre fabricante" FROM producto p join fabricante f ON p.codigo_fabricante = f.codigo;

-- 38. Devuelve una lista con el nombre del producto, precio y nombre de fabricante de todos los productos de la base de datos. 
--Ordene el resultado por el nombre del fabricante, por orden alfabético.
SELECT p.nombre AS "Nombreprodcuto", p.precio AS "precioprodcuito",f.nombre AS "nombre fabricante" FROM producto
p JOIN fabricante f ON p.codigo_fabricante = f.codigo ORDER BY f.nombre ASC;

-- 39. Devuelve una lista con el identificador del producto, nombre del producto, identificador del fabricante y nombre del fabricante, de todos los productos de la base de datos.
SELECT p.codigo_fabricante AS "Codigo producto",p.nombre AS "NOMBRE PRODUCTO",f.codigo AS "CODIGO FABRICANTE",f.nombre AS "NOMBRE FABRICANTE"
FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo;

-- 40. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más barato.
SELECT p.nombre AS "NOMBRE PRODCUTO", p.precio AS "PRECIO PRODUICTO", f.nombre AS "nombre fabricante"
FROM producto p JOIN fabricante f ON p.codigo_fabricante =f.codigo ORDER BY p.precio LIMIT 1;

SELECT p.nombre AS "Nombre del Producto", p.precio AS "Precio Producto", f.nombre AS "Nombre del Fabricante"
FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE p.precio = (SELECT MIN(precio) FROM producto);

-- 41. Devuelve el nombre del producto, su precio y el nombre de su fabricante, del producto más caro.
SELECT p.nombre AS "Nombre del Producto", p.precio AS "Precio Producto", f.nombre AS "Nombre del Fabricante" FROM producto p
JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE p.precio = (SELECT MAX(precio) FROM producto);

-- 42. Devuelve una lista de todos los productos del fabricante Lenovo.
SELECT nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Lenovo');

-- 43. Devuelve una lista de todos los productos del fabricante Crucial que tengan un precio mayor que 200€.
SELECT nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Crucial') AND precio > 200;

-- 44. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate. Sin utilizar el operador IN.
SELECT nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Asus')
OR codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Seagate') 
OR codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = 'Hewlett-Packard');

SELECT p.nombre AS "Nombre del Producto" FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE f.nombre = "ASUS" OR 
f.nombre = "Seagate" OR f.nombre = "Hewlett-Packard";

-- 45. Devuelve un listado con todos los productos de los fabricantes Asus, Hewlett-Packard y Seagate. Utilizando el operador IN.
SELECT p.nombre AS "Nombre del Producto"FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo
WHERE f.nombre IN ("Asus", "Hewlett-Packard", "Seagate");

SELECT nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre IN ("Asus", "Hewlett-Packard", "Seagate"));

-- 46. Devuelve un listado con el nombre y el precio de todos los productos de los fabricantes cuyo nombre termine por la vocal e.
SELECT nombre, precio FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre LIKE "%e");

-- 47. Devuelve un listado con el nombre y el precio de todos los productos cuyo nombre de fabricante contenga el carácter w en su nombre.
SELECT nombre, precio FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre LIKE "%w%");

-- 48. Devuelve un listado con el nombre de producto, precio y nombre de fabricante, de todos los productos que tengan un precio mayor o igual a 180€.
-- Ordene el resultado en primer lugar por el precio (en orden descendente) y en segundo lugar por el nombre (en orden ascendente)
SELECT p.nombre AS "Nombre del Producto", p.precio AS "Precio", f.nombre AS "Nombre del Fabricante"
FROM producto p JOIN fabricante f ON p.codigo_fabricante = f.codigo WHERE p.precio >= 180 ORDER BY p.precio DESC, p.nombre ASC;

-- 49. Devuelve un listado con el identificador y el nombre de fabricante, solamente de aquellos fabricantes que tienen productos asociados en la base de datos.
SELECT codigo, nombre FROM fabricante WHERE codigo IN (SELECT DISTINCT codigo_fabricante FROM producto)

-- 50. Devuelve un listado de todos los fabricantes que existen en la base de datos, junto con los productos que tiene cada uno de ellos.
--El listado deberá mostrar también aquellos fabricantes que no tienen productos asociados.
SELECT f.codigo, f.nombre, p.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante;

-- 51. Devuelve un listado donde sólo aparezcan aquellos fabricantes que no tienen ningún producto asociado.
SELECT f.* FROM fabricante f LEFT JOIN producto p ON f.codigo = p.codigo_fabricante WHERE p.codigo IS NULL;

-- 52. ¿Pueden existir productos que no estén relacionados con un fabricante? Justifique su respuesta.

-- NO PORQUE VIOLARIA LA INTEGRIDAD REFERENCIAL, Campo codigo_fabricante en la tabla producto debería ser una clave externa 
-- que haga referencia al campo codigo en la tabla fabricante.

-- 53. Devuelve todos los productos del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = "Lenovo");  

-- 54. Devuelve todos los datos de los productos que tienen el mismo precio que el producto más caro del fabricante Lenovo. (Sin utilizar INNER JOIN).
SELECT * FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = "Lenovo"));

-- 55. Lista el nombre del producto más caro del fabricante Lenovo.
SELECT nombre FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = "Lenovo") ORDER BY precio DESC LIMIT 1;

SELECT nombre FROM producto WHERE precio = (SELECT MAX(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = "Lenovo"));

-- 56. Lista el nombre del producto más barato del fabricante Hewlett-Packard.
SELECT nombre FROM producto WHERE precio = (SELECT MIN(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = "Hewlett-Packard"));

-- 57. Devuelve todos los productos de la base de datos que tienen un precio mayor o igual al producto más caro del fabricante Lenovo.
SELECT * WHERE precio >= (SELECT precio FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = "Lenovo") ORDER BY precio DESC LIMIT 1;)

-- 58. Lista todos los productos del fabricante Asus que tienen un precio superior al precio medio de todos sus productos.
SELECT * FROM producto WHERE codigo_fabricante = ( SELECT codigo FROM fabricante WHERE nombre = 'Asus' ) AND 
precio > ( SELECT AVG(precio) FROM producto WHERE codigo_fabricante = ( SELECT codigo FROM fabricante 
WHERE nombre = 'Asus' ) );

SELECT * FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = "Asus") AND
precio > (SELECT AVG(precio) FROM producto WHERE codigo_fabricante = (SELECT codigo FROM fabricante WHERE nombre = "Asus"));

-- 59. Devuelve el producto más caro que existe en la tabla producto sin hacer uso de MAX, ORDER BY ni LIMIT.
SELECT * FROM producto WHERE precio >= ALL (SELECT precio FROM producto);

-- 60. Devuelve el producto más barato que existe en la tabla producto sin hacer uso de MIN, ORDER BY ni LIMIT.
SELECT * FROM producto WHERE precio <= ALL (SELECT precio FROM producto);

-- 61. Devuelve los nombres de los fabricantes que tienen productos asociados. (Utilizando ALL o ANY).
SELECT nombre FROM fabricante WHERE codigo = ALL (SELECT codigo_fabricante FROM producto);

-- 62. Devuelve un listado con todos los nombres de los fabricantes que tienen el mismo número de productos que el fabricante Lenovo.

SELECT f.nombre FROM fabricante f WHERE
    (SELECT COUNT(*)
    FROM producto p
    WHERE p.codigo_fabricante = f.codigo)
    =
    (SELECT COUNT(*)
    FROM producto p
    WHERE p.codigo_fabricante = ( SELECT codigo FROM fabricante WHERE nombre = 'Lenovo' ));