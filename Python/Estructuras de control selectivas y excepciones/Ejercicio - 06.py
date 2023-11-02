'''Escribe un algoritmo que tras leer tres enteros los escriba en pantalla en orden
creciente. Como siempre, valida las entradas.'''

def ordenar_creciente(n1, n2, n3):
    menor = n1
    mediano = n2
    mayor = n3

    if n1 < n2 and n1 < n3:
        menor = n1
        if n2 < n3:
            mediano, mayor = n2, n3
        else: 
            mediano, mayor = n3, n2
    
    if n2 < n1 and n2 < n3:
        menor = n2
        if n1 < n3:
            mediano, mayor = n1, n3
        else:
            mediano, mayor = n3, n1
    
    if n3 < n1 and n3 < n2:
        menor = n3
        if n1 < n2:
            mediano, mayor = n1, n2

        else:
            mediano, mayor = n2, n1

    return menor, mediano, mayor

print(ordenar_creciente(1,4,3))
print(ordenar_creciente(3,2,1))
print(ordenar_creciente(1,0,3))
print(ordenar_creciente(3,0,1))