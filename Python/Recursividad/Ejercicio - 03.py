""" 3. Implementa una función recursiva que averigüe si todos los elementos de una lista son iguales a uno dado."""

def todos_iguales(sec, elem):
    if 1 == len(sec):
        son_iguales = sec[0] == elem
    else:
        son_iguales = sec[0] == elem and todos_iguales(sec[1:len(sec)], elem) 
    
    return son_iguales

lista = [1,1,1,1,1,3]
print(todos_iguales(lista, 1))