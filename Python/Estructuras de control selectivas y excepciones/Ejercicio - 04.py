"""Reprograma lo hecho en el ejercicio 2 para reutilizar el validador de enteros del
ejercicio 3. Obviamente, tendrás que seguir validando que los valores de hora y
minutos se encuentran en el rango correcto."""

def validar_entero(n):
    try:
        int(n)
        return True
    except: return False

def cambio_formato(hora, min):
        if validar_entero(hora) == True and validar_entero(min) == True:
            if hora >= 0 or hora <= 24 or min >= 0 or min<=60: 
                formato = 'AM'
                if hora > 12:
                    hora = hora - 12
                    formato = 'PM'
                    hora_real = str(hora) + ':' + str(min) + ' ' + formato
                return hora_real
        else:
            print('INTRODUCE DATOS VALIDOS')
    
print(cambio_formato(19,20))