""" 2. Programa una función que evalúe si dos fechas, definidas en términos de día, mes y año, son iguales.
Los argumentos recibidos corresponden a fechas válidas."""

from recordclass import recordclass   

tFecha = recordclass('Fecha', 'dia, mes, anno')

def CompararFechas(tFecha, tFecha2):
    """
    tFecha, tFecha2 --> bool
    OBJ: comparar fechas
    PRE: fechas validas
    """
    return tFecha == tFecha2

#PROBADOR

tFecha1 = tFecha(1,2,3)
tFecha2 = tFecha(1,2,3)

print(CompararFechas(tFecha1, tFecha2))