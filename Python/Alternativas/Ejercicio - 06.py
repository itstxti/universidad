""" 6. En las actas universitarias es necesario expresar la calificación numérica y
también la textual según el siguiente criterio: 
0<=nota<5 suspenso, 5<=nota<7 aprobado, 7<=nota<9 notable 9<=nota<10 sobresaliente, nota=10 M. Honor. 
Haz un subprograma que reciba una calificación numérica comprendida entre 0 y 10 y
devuelva la calificación textual. Recuerda anidar los condicionales."""

def obtener_calificacion_textual(calificacion):
    if 0 <= calificacion < 5:
        return 'Suspenso'
    elif 5 <= calificacion < 7:
        return 'Aprobado'
    elif 7 <= calificacion < 9:
        return 'Notable'
    elif 9 <= calificacion < 10:
        return 'Sobresaliente'
    elif calificacion == 10:
        return 'M. Honor'
    else:
        return 'Calificación inválida'

# PROGRAMA

calificacion = float(input("Introduce la calificación numérica: "))
calificacion_textual = obtener_calificacion_textual(calificacion)
print("La calificación textual es:", calificacion_textual)