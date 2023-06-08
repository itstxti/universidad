""" 1. Realiza un programa que lea desde teclado un número y calcule su factorial empleando recursividad."""

def factorial (n):
    """
    int --> int
    OBJ: calcular n!
    PRE: n >= 0
    """
    if n==(0) or n==(1):
        f = 1
    else:  f = n * factorial (n-1)
    return f;

#PROBADOR

print(factorial(3), "es igual a 6.")
print(factorial(1), 'es igual a 1')
print(factorial(0), 'es igual a 1')

#PROGRAMA

try:
    n = int(input('Introduce un numero: '))
    print('El factorial de', n, 'es', factorial(n))
except: print('Error, el número introducido no es válido.')
else: 
    if n < 0:
        print('El número tiene que ser igual o mayor que cero.')