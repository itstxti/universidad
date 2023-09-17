""" 1. Programa una función que evalúe si dos fechas, definidas en términos de día, mes y año, son iguales.
Los argumentos recibidos corresponden a fechas válidas."""

from recordclass import recordclass   

tFecha = recordclass('Fecha', 'dia, mes, anno')

def CompararFechas(f1, f2):
    """
    tFecha, tFecha --> bool
    OBJ: comparar fechas
    PRE: fechas validas
    """
    return f1 == f2

#PROBADOR

f1 = tFecha(1,2,3)
f2 = tFecha(1,2,3)

print(CompararFechas(f1, f2))