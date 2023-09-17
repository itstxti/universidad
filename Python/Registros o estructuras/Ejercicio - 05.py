""" 5. Los casos de prueba de la propuesta de solución 1 no son verdaderamente suficientes. Complétalos, justificando la respuesta."""

from recordclass import recordclass

tFecha = recordclass('Fecha', 'dia mes anno')

def son_iguales(fecha1,fecha2):
    """ tFecha, tFecha -> bool
    OBJ: son iguales fecha1 y fecha2?
    PRE: fechas válidas"""
    return fecha1 == fecha2

# PROBADOR
f1 = tFecha(1,12,2022)
f2 = tFecha(1,12,2021)

print(f1, 'y', f1, 'son iguales: ', son_iguales(f1,f1))  # fechas iguales
print(f1, 'y', f2,'no son iguales: ', son_iguales(f1,f2)) # dia y mes iguales, año diferente

f3 = tFecha(2,12,2022)
f4 = tFecha(1,11,2022)

print(f3, 'y', f1, 'no son iguales: ', son_iguales(f3, f1)) # mes y año iguales, dia diferente
print(f4, 'y', f1, 'no son iguales: ', son_iguales(f4, f1)) # dia y año, mes diferente