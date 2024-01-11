-- 1. Muestra los títulos de los libros publicados después del año 2000.
SELECT titulo FROM libros WHERE anio_publicacion > 2000;

-- 2. Muestra los autores que tienen al menos dos libros en la biblioteca.
SELECT nombre_autor FROM autores WHERE autor_id = (SELECT autor_id FROM libros GROUP BY autor_id HAVING COUNT(isbn) >= 2);

-- 3. Obtén el número total de libros por género.
SELECT genero, COUNT(genero) FROM libros GROUP BY genero;

-- 4. Encuentra el autor con más libros en la biblioteca.
SELECT nombre_autor FROM autores WHERE autor_id = (SELECT autor_id FROM libros GROUP BY autor_id ORDER BY COUNT(*) DESC LIMIT 1);

-- 5. Muestra los libros junto con el nombre del autor, ordenados por año de publicación de forma descendente.
SELECT l.titulo, a.nombre_autor FROM libros l JOIN autores a ON l.autor_id = a.autor_id ORDER BY l.anio_publicacion DESC;

-- 6. Encuentra el libro más antiguo en la biblioteca.
SELECT titulo FROM libros ORDER BY anio_publicacion ASC LIMIT 1;

-- 7. Obtén una lista de todos los autores y el número de libros que han escrito.
SELECT a.Nombre_Autor, COUNT(*) FROM Autores a LEFT JOIN Libros l ON a.Autor_ID = l.Autor_ID GROUP BY a.Autor_ID;

-- 8. Muestra los títulos de los libros y sus géneros, pero excluye los libros de ficción.
SELECT titulo, genero FROM libros WHERE genero != "Fiction";

-- 11. Encuentra los libros cuyo título contiene la palabra "Programming".
SELECT titulo FROM libros WHERE titulo LIKE "%Programming%";

-- 12. Muestra los autores que han escrito al menos un libro de ficción.
SELECT nombre_autor FROM autores WHERE autor_id = (SELECT autor_id FROM libros WHERE genero = "Fiction" GROUP BY genero HAVING COUNT((*) >= 1))
 
-- 14. Obtén la cantidad total de libros escritos por autores de nacionalidad estadounidense.

-- 15. Muestra los autores que han escrito libros en más de un género.

-- 16. Encuentra los libros que tienen el mismo año de publicación y muéstralos agrupados.

-- 17. Calcula la diferencia de precio entre el libro más caro y el más barato.

-- 18. Encuentra los libros que fueron publicados en el mismo año que "To Kill a Mockingbird".

-- 19. Muestra los autores y el número de libros que tienen un precio superior al promedio.

-- 20. Encuentra los autores que han escrito libros en todos los géneros disponibles.

-- 21. Muestra los cinco autores con el mayor número total de páginas escritas, considerando que cada libro tiene 300 páginas en promedio.

-- 22. Encuentra el porcentaje de libros de cada género en comparación con el total de libros.

-- 23. Calcula la diferencia de precio entre cada libro y el libro más caro en el mismo género. Muestra el título del libro, el género y la diferencia de precio.

-- 24. Encuentra el autor que ha tenido el mayor aumento en el número de libros publicados en los últimos dos años.

-- 25. Calcula el precio promedio de los libros para cada autor. Muestra el nombre del autor y el precio promedio, ordenado de mayor a menor precio promedio.
-- 26. Muestra los libros que tienen un precio que está por encima del promedio de su género, pero por debajo del promedio general de todos los libros.

-- 27. Encuentra los géneros que tienen al menos un libro escrito por cada autor.

-- 28. Calcula la diferencia en años entre el año de publicación del libro y el año en que el autor cumplió 40 años. Muestra el título del libro, el nombre del autor y la diferencia en años.

-- 29. Encuentra el libro que tiene la mayor cantidad de páginas escritas por cada autor.

-- 30. Muestra los libros que tienen un precio superior al precio promedio de los libros escritos por autores de nacionalidad no estadounidense.

-- 31. Encuentra el nombre del autor que tiene la mayor cantidad de libros de ficción.

-- 32. Calcula la suma acumulativa de los precios de los libros para cada género, ordenada por género y año de publicación.

-- 33. Encuentra los libros que tienen un precio que está por debajo del precio promedio de los libros publicados en el mismo año.

-- 34. Calcula el número de años desde la última publicación de cada autor hasta el año actual. Muestra el nombre del autor y el número de años.

-- 35. Encuentra los autores que han escrito al menos un libro en cada década desde su primera publicación hasta la última.

-- 36. Muestra los títulos de los libros que tienen más páginas que el libro promedio del mismo género y fueron publicados en el mismo año.

-- 37. Encuentra los autores que han escrito libros en todos los géneros, pero excluye a aquellos que han escrito menos de cinco libros en total.

-- 38. Calcula la clasificación de cada libro en comparación con otros libros del mismo género en términos de precio. Muestra el título del libro, el género y la clasificación.

-- 39. Encuentra los autores cuya edad actual es mayor que la edad promedio de todos los autores.

-- 40. Muestra los títulos de los libros que tienen un precio que está por encima del precio promedio de los libros publicados en el mismo año y del mismo género.