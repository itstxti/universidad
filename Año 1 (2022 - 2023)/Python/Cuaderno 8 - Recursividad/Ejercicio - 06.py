""" 6. Programa ahora un algoritmo recursivo que permita hacer una división entera mediante restas sucesivas."""

def division(n1, n2):
    total = 0
    if n1 == 0 or n2 == 0:
        print('ERROR. NO SE PUEDE DIVIDIR ENTRE 0.')
    elif n2 == 1:
        return n1
    else:
        total += 1
        return n1 - division(n1, n2 - 1)
    

print(division(4,2))