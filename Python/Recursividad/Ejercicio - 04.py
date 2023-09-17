""" 4. Programa un algoritmo recursivo que indique a la pieza llamante si un número se encuentra o no en una lista de números."""

def encuentra(sec, elem):
    if len(sec) == 0:
        return False

    if sec[0] == elem:
        return True
    else:
        return encuentra(sec[1:len(sec)], elem)

# PROBADOR

sec = [1,2,3,4,5]
print(encuentra(sec, 1))