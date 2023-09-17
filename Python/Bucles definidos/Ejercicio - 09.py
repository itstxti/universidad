""" 9. Escribe una función que sume dos listas de enteros de igual longitud
y retorne otra lista que contenga la suma de las originales elemento a elemento.
Haz otra versión permitiendo que las listas sean desiguales.
Los elementos sobrantes de la lista más larga se añadirán al final de la lista resultante."""

def sumar_listas_iguales(lista, lista2):
    """PRE: las listas tienen la misma longitud."""
    resultado = []
    for i in range(len(lista)):
        resultado.append(lista[i] + lista2[i])
    return resultado

print(sumar_listas_iguales([1,2,3], [1,2,3]))

def sumar_listas_desiguales(lista1, lista2):
    resultado = []
    max_longitud = max(len(lista1), len(lista2))

    for i in range(max_longitud):
        if i < len(lista1):
            num1 = lista1[i]    
        else: 0

        if i < len(lista2):
            num2 = lista2[i]    
        else: 0

        suma = num1 + num2
        resultado.append(suma)

    return resultado

print(sumar_listas_desiguales([1,2,3,4], [1,2,3, 4]))