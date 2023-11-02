"""Escribe un subprograma que lea una hora en notación de 24 horas y la devuelva
en notación de 12 horas (ejemplo: las 18:30 serán las 6:30 PM). Pruébalo utilizando
valores introducidos por el usuario, pero no olvides validad las entradas para
asegurarte de que se trata de valores en el rango correcto."""

def cambio_formato(hora, min):
    if hora >= 0 and hora <= 24 and min >= 0 and min<=60: 
        formato = 'AM'
        if hora > 12:
            hora = hora - 12
            formato = 'PM'
        return str(hora) + ':' + str(min) + ' ' + formato
    else: print('DATOS FUERA DE RANGO')
    
try:
    hora = int(input('INTRODUCE LA HORA: '))
    min = int(input('INTRODUCE LOS MINUTOS: '))
    print(cambio_formato(hora, min))
except:
    print('DATOS NO VALIDOS')