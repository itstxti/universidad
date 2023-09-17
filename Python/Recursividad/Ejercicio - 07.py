""" 7. Programa, haciendo uso de la recursividad, una función en Python
que permita obtener el término de orden n de la sucesión de Fibonacci."""

def sucesion_fibonacci(n):
    if n == 0 or n == 1:
        return 1
    else:
        return sucesion_fibonacci(n - 2) + sucesion_fibonacci(n - 1)

          
# PROGRAMA

try:
    n = int(input('Introduce el termino que quieres de la sucesión de Fibonacci: '))
    print(sucesion_fibonacci(n)) # Pimer termino = 0.
except:
    print('Error, el número introducido no es válido.')