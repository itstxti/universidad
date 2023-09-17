""" 6. Haz una función que sume todos los valores de una lista."""

PIEZAS_M = (50000,20000,10000,5000,2000,1000,500,200,100,50,20,10,5,2,1) # valores monetarios de españa en centimos.

def sumar_elementos_listas(lista):
    total=0
    for i in lista:
        total += i
    return total

print(sumar_elementos_listas(PIEZAS_M)/100) # SUMA EN EUROS.
print(sumar_elementos_listas([3,6,1,7,3,0,4,1,7]))