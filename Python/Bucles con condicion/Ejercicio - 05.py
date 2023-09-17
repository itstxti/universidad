""" 5. La universidad establece, a principio de curso, el calendario de exámenes.
Salvo fuerza mayor, el alumno matriculado tiene derecho a que no varié el calendario.
Algunos alumnos han pedido retrasar el examen de FP.
La lista quieres_cambiar= (True, True, False, True…) contiene un ejemplo del voto de cada uno de los alumnos de clase.
Si todos están de acuerdo se cambiará.
Si nadie está en desacuerdo se cambiará.
Haz un subprograma que determine si hay unanimidad en cambiarlo."""

quieres_cambiar= (True, True, True, False)

def unanimidad(lista):
    
    for i in range(0, len(lista)):
        if lista[i] == False:
            return False
    else: return True

print(unanimidad(quieres_cambiar))