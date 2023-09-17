""" 5. Implementa un programa que, dados dos números, calcule el producto de forma recursiva.
Los números a multiplicar deben ser leídos por teclado.
NOTA: no puede utilizar el operador de multiplicación así que utilice sumas."""


def multiplicar(n1, n2):
    if n2 == 0 or n1 == 0:
        return 0
    elif n2 == 1:
        return n1
    else:
        return n1 + multiplicar(n1, n2 - 1)


# PROGRAMA

try:
    n1 = int(input('Introduce un número: '))
    n2 = int(input('Introduce otro número: '))

    print('El resultado es:', multiplicar(n1, n2))

except:
    print('Error, el número introducido no es válido.')