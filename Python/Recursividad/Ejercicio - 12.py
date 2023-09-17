""" 12. Calcula la suma de los números pares entre n y m de manera recursiva.
Por defecto n vale cero.  Por ejemplo, entre 11 y 15 =12+14=26.
Entre 0 y 14=56. Entre 15 y 11=0."""

def suma_pares(n1, n2):
    
    if n1 > n2:
        return 0
    if n1 % 2 != 0:
        return suma_pares(n1+1, n2)
    if n1 % 2 == 0:
        return n1 + suma_pares(n1+2, n2)

# PROBADOR

print(suma_pares(10,14), 10 + 12 + 14)
print(suma_pares(18,13), 0)
print(suma_pares(5,11), 6 + 8 + 10)

# PROGRAMA

try: 

    n1 = int(input('Introduce un número: '))
    n2 = int(input('Introduce otro número: '))
    print(suma_pares(n1,n2))

except:

    print('ERROR, los números introducidos no son válidos')