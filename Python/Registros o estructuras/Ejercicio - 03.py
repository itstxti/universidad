""" 3. Reutilizando las soluciones anteriores haz un subprograma que deje a disposición de la memoria del ordenador,
de forma cómoda si una fecha es posterior a otra."""

from recordclass import recordclass

tFecha = recordclass('tFecha', 'dia mes anno')

def CompararFechas(f1, f2):
    """
    tFecha, tFecha --> bool
    OBJ: comparar fechas
    PRE: fechas validas
    """
    return f1 == f2

def FechaAnterior(f1, f2):
    """
    tFecha, tFecha --> bool
    OBJ: f1 es o no anterior de f2
    PRE: fechas validas
    """
    return (f1.anno < f2.anno) or (f1.anno == f2.anno and f1.mes < f2.mes) or (f1.anno == f2.anno and f1.mes == f2.mes and f1.dia < f2.dia)

def FechaPoserior(f1,f2):
    """
    tFecha, tFecha --> bool
    OBJ: f1 es o no posterior de f2
    PRE: fechas validas
    """
    return not FechaAnterior(f1,f2) and not CompararFechas(f1,f2)

f1 = tFecha(2,1,2)
f2 = tFecha(1,2,2)

print(FechaPoserior(f1, f2))
print(FechaPoserior(f2, f1))