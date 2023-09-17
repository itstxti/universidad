""" 5. La tupla días_mes contiene el número de días que tiene cada uno de los meses de un año bisiesto.
Haz un programa que cuente cuantos meses de un año bisiesto tienen un número determinado de días."""

dias_mes = (31,29,31,30,31,30,31,31,30,31,30,31)

def contador(lista, elem):
    contador = 0
    for i in lista:
        if i == elem:
            contador += 1
    return contador

print(contador(dias_mes, 30))