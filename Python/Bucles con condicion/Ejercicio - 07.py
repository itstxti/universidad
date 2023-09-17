""" 7. Generaliza, modifica, tu código para que, en las situaciones del ejercicio anterior,
el usuario pueda contestar en el idioma que desee, por ejemplo: Si/NO, en inglés YES/NO,
francés OUI/NE, bool: T/F/0/1, pero también podrá decir Aceptar/Cancelar/NUNCA/CLARO, etc.
Y además podrá hacerlo en mayúsculas o minúsculas.
Tu código debe ser muy fácil de mantener ante la posibilidad de incluir nuevos idiomas
o voces de afirmación o negación. """

def confirmar(msg, si, no):
    respuesta = input(msg)
    if respuesta.upper() == si.upper():
        return True
    elif respuesta.upper() == no.upper():
        return False
    else:
        print("Respuesta inválida. Por favor, responda", si, "o", no)
        return confirmar(msg, si, no)

print(confirmar("Quieres eliminar LoL: ", 'aceptar', 'cancelar'))