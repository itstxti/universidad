""" 6. Siguiendo el esquema sencillo “pedir datos al usuario”, codifica el subprograma
que pida confirmación al usuario (de cualquier cuestión). Valdrá por ejemplo para: 
•	¿eres mayor de edad?, 
•	¿desea salir sin guardar las modificaciones? 
•	¿seguro que desea borrar definitivamente el archivo?
•	La aplicación aún se está ejecutando ¿desea matarla?... 
El subprograma devolverá a memoria un booleano en función de que el usuario haya escrito “SI” o “NO”."""

def confirmar(msg):
    respuesta = input(msg)
    if respuesta.upper() == 'SI':
        return True
    elif respuesta.upper() == 'NO':
        return False
    else:
        print("Respuesta inválida. Por favor, responda 'SI' o 'NO'.")
        return confirmar(msg)

print(confirmar("ERES MAYOR DE EDAD: "))