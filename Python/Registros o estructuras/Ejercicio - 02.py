""" 2. Implementa ahora una función que indique si una fecha es anterior a otra. Todas las fechas a considerar seran válidas."""

from recordclass import recordclass

tFecha = recordclass('tFecha', 'dia mes anno')

def FechaAnterior(f1, f2):
    """
    tFecha, tFecha --> bool
    OBJ: f1 es o no anterior de f2
    PRE: fechas validas
    """
    return ((f1.anno < f2.anno) or (f1.anno == f2.anno and f1.mes < f2.mes) or 
    (f1.anno == f2.anno and f1.mes == f2.mes and f1.dia < f2.dia))

f1 = tFecha(1,2,1)
f2 = tFecha(1,2,2)

print(FechaAnterior(f1, f2))