""" 3. Implementa una función recursiva que muestre los pares de valores a sumar
para mostrar la suma de los extremos de una lista. Por ejemplo, para la lista [1,2,3,4,7,8,9]
mostrará 1+9, en la siguiente línea 2 + 8, en la siguiente 3 + 7 y en la última 4.
Si la lista tuviera un número par de valores, como [1,2,3,4] mostraría 1+4 y en la siguiente línea 2+3. [2 puntos]"""

def extremos_listas(lista):
    inicio = 0
    fin = len(lista)-1
    while inicio < fin:
        print(lista[inicio] + lista[fin])
        inicio += 1
        fin -= 1
    if inicio == fin:
        print(lista[inicio])
    
#extremos_listas([1,2,3,4,5,7,8,9])
#extremos_listas([1,2,3,4,5,7,8])

def otro_misterio(L, n, cuanto):
  for i in range(len(L)):
    L[n][i] += cuanto
  print(L[n])

sublista = [1,2,3,4,5]
lista = []
for i in range(5):
  lista.append(sublista)

otro_misterio(lista,0, 3)
print(lista)
