""" Escribe un programa modularizado que a partir de una hora en formato [hora,
minutos y segundos] y utilizando una función que calcule el número total de
segundos transcurridos desde la última medianoche, lo muestre
posteriormente por pantalla. """

def segundos_transcurridos(horas, min, seg):
    """
    int, int, int --> int
    OBJ: segundos transcurridos desde 0:00
    PRE: 
    """
    return horas*3600 + min*3600 + seg

# PROBADOR

print(segundos_transcurridos(1,4,3)) 
