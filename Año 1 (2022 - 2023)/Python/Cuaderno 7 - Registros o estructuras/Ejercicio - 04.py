""" 4. En el ejercicio 1, la propuesta de solución pregunta dos veces si los años son iguales,
lo cual consume tiempo de ejecución y dificulta el mantenimiento.
Elimina dicha redundancia coordinando adecuadamente el orden de operaciones."""

from recordclass import recordclass   

tFecha = recordclass('Fecha', 'dia, mes, anno')

def CompararFechas(tFecha, tFecha2):
    """
    tFecha, tFecha2 --> bool
    OBJ: comparar fechas
    PRE: fechas validas
    """
    return tFecha.dia == tFecha2.dia and tFecha.mes == tFecha2.mes and tFecha.anno == tFecha2.anno

#PROBADOR

tFecha1 = tFecha(1,1,3)
tFecha2 = tFecha(1,2,3)

print(CompararFechas(tFecha1, tFecha2))