"""4. Codifica una pieza de código que lea, por teclado, los datos relativos a una persona.
Recuerda que en tu biblioteca interfaz, debes tener disponible el subprograma entero_pedido.
Si no es así, inclúyelo allí ahora y reúsalo aquí. 
Probablemente te convenga subprogramar sexo_pedido, pues solo aceptamos V o M para varón o mujer, respectivamente. 
o hay, en el mundo real, restricciones para un pseudónimo, incluso puede estar vacío."""

def entero_pedido(min, msg):
    pedir = True
    while  pedir or not (min<n):
        try: n = int(input(msg))
        except: print('INTRODUCE UNA EDAD VÁLIDA.')
        else: pedir = False        
    return n

def sexo_pedido(msg):
    pedir = True
    while pedir:
        n = input(msg).upper()
        if n == 'M' or n == 'V':
            pedir = False 
        else: pedir = True        
    return n


from recordclass import recordclass

tPersona = recordclass('Persona', 'Pseudonimo, sexo, edad')

def pedir_datos():
    
    pseu = input('INTRODUCE UN PSEUDÓNIMO: ')
    edad = entero_pedido(0, 'INTRODUCE TU EDAD: ')
    sex = sexo_pedido('INTRODUCE TU SEXO: ')
    persona = tPersona(pseu, sex, edad)

    return persona

print(pedir_datos())