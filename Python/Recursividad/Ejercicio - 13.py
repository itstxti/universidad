""" 13. Programa un algoritmo recursivo que obtenga la suma de las edades de todos los elementos de una lista de alumnos.
Un alumno está caracterizado por tres atributos (nombre, edad, titulacion)."""

from recordclass import recordclass

tAlumno = recordclass('Alumno', 'nombre edad titulacion')


def suma_edades(lista):
    if len(lista) == 0:
        return 0
    if len(lista) == 1:
        return lista[0].edad
    else:
        return lista[0].edad + suma_edades(lista[1:len(lista)])


# PROBADOR

a1 = tAlumno('JUAN', 19, 'DERECHO')
a2 = tAlumno('MASI', 18, 'COMUNICACION AUDIOVISUAL')
a3 = tAlumno('ANDRES', 21, 'BIOLOGIA')
a4 = tAlumno('GUILLERMO', 25, 'INGENIERIA INFORMATICA')


alumnos = [a1, a2, a3, a4]


print(suma_edades([]), '=', 0) # lista vacia
print(suma_edades([a3, a2, a4]), '=', 21 + 18 + 25) 
print(suma_edades(alumnos), '=' , 19 + 18 + 21 + 25)