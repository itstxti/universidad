""" 6. Diseña las estructuras de datos que permitan almacenar información sobre un número determinado de
personas con objeto de hacer un estudio estadístico. De cada persona se deberá almacenar un pseudónimo, sexo y edad."""

from recordclass import recordclass

tPersona = recordclass('Persona', 'Pseudonimo, sexo, edad')

personas = [tPersona('Luis', 'H', 22),
            tPersona('Luisa', 'M', 28)]

print(personas) 