""" 4. Sin modularizar, puesto que no va a ser muy reusable,
genera por pantalla las tablas de multiplicar de los pares."""

def tabla_multiplicar(n):
    print('TABLA DE MULTIPLICACIÓN DEL', n)
    for i in range(0, 11):
        print(n, 'x', i, '=', i*n)

for i in range(0, 11, 2):
    tabla_multiplicar(i)