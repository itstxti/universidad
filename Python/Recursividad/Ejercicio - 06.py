""" 6. Programa ahora un algoritmo recursivo que permita hacer una división entera mediante restas sucesivas."""

def division(n1, n2):
    total = 0
    if n1 == 0:
        return total
    elif n1-n2 == 0:
        total += 1
        return total
    else:
        total +=1
        return total + division(n1-n2, n2)


# PROGRAMA

try:
    n1 = int(input('Introduce un número: '))
    n2 = int(input('Introduce otro número: '))

    print('El resultado es:', division(n1, n2))
    
except:
    print('Error, el número introducido no es válido.')