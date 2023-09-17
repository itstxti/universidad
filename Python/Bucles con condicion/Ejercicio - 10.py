""" 10. Al menos 12 caracteres de longitud, pero 14 o más es mejor.
Una combinación de letras mayúsculas, minúsculas, números y símbolos.
Haz un subprograma que responda si una cadena de caracteres dada es contraseña cumple las condiciones exigidas.
Haz un subprograma que pida al usuario una contraseña hasta que sea válida."""

def es_contrasena_valida(contrasena):
    longitud_valida = len(contrasena) >= 12
    simbolos = "!@#$%^&*()-_=+[{]}\|;:'\",<.>/?"

    tiene_letras_mayusculas = False
    tiene_letras_minusculas = False
    tiene_numeros = False
    tiene_simbolos = False

    for caracter in contrasena:
        if caracter.isupper():
            tiene_letras_mayusculas = True
        elif caracter.islower():
            tiene_letras_minusculas = True
        elif caracter.isdigit():
            tiene_numeros = True
        elif caracter in simbolos:
            tiene_simbolos = True

    cumple_requisitos = (
        longitud_valida and
        tiene_letras_mayusculas and
        tiene_letras_minusculas and
        tiene_numeros and
        tiene_simbolos
    )

    return cumple_requisitos


def solicitar_contrasena():
    contrasena = input("Introduce una contraseña: ")

    while not es_contrasena_valida(contrasena):
        print("La contraseña no cumple con los requisitos. Intenta nuevamente.")
        contrasena = input("Introduce una contraseña: ")

    print("Contraseña válida.")


solicitar_contrasena()