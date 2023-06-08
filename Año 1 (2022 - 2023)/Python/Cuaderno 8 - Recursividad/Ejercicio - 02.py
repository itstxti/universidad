""" 2. Implementa una función recursiva que averigüe si todos los elementos de una lista,
a partir de una posición de la misma, son iguales a uno dado."""

def todos_iguales(sec, elem, pos):
    """
    sec, elem, int --> bool
    OBJ: elementos de sec a partir de pos y en pos son o no iguales a elem?
    PRE: pos>=0, pos<len(sec)-1, elem comparable a elementos de sec
    """
    if (pos == len(sec)-1):
        son_igual = elem == sec[pos]
    else:
        son_igual = elem == sec[pos] and todos_iguales(sec, elem, pos+1)
    return son_igual


#PROBADOR

lista = [1,1,2,1,1,1]
print(todos_iguales(lista, 1, 3))
abc = ["a", "a", "b", "a", "b"]
print(todos_iguales(abc, 'b', 4))