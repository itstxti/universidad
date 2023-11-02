"""Una universidad acaba de modificar su sistema de representación de la calificación
de los alumnos. A partir de ahora, se calificarán como “A” las notas mayores o
iguales a 8,5, “B” las mayores o iguales a 6,5, “C” las calificaciones mayores o
iguales a 5, “D” las calificaciones mayores o iguales a 3,5, y “F” todas las demás.
Programa una función que reciba una calificación numérica y retorne la letra con la
nueva calificación, luego pruébala con valores introducidos por el usuario. Tal vez
sea buena idea basarte en el ejercicio resuelto número 1 pero, a diferencia de lo
que se hace allí (se controla la validez con una precondición), asegúrate de que la
calificación introducida es válida."""

def cambio_nota(n):
    if n >= 0 and n <= 10:
        if n >= 8.5:
            n = 'A'
        if n >= 6.5:
            n = 'B'
        if n >= 5:
            n = 'C'
        if n >= 3.5:
            n = 'D'
        else:
            n = 'F'
        return n
    else: print('DATOS FUERA DE RANGO')


try:
    n = int(input('INTRODUCE TU NOTA: '))
    print(cambio_nota(n))
except:
    print('DATOS NO VALIDOS.')