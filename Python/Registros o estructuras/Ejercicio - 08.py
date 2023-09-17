"""8. Programa un software que, utilizando la pieza que solicita datos de un participante al usuario,
lee los datos de 10000 personas, devolviendo los datos del sondeo completo en una sola variable
(todos los datos de todas las personas).
En el mensaje de solicitud al usuario deseamos que escriba persona 1, persona 2,…
¿Cómo consigues que cada vez añada un número distinto si persona pedida tiene un solo argumento?"""

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

def persona_pedida(n):

    print('PERSONA', n)
    pseu = input('INTRODUCE UN PSEUDÓNIMO: ')
    edad = entero_pedido(0, 'INTRODUCE TU EDAD: ')
    sex = sexo_pedido('INTRODUCE TU SEXO: ')
    persona = tPersona(pseu, sex, edad)

    return persona

def varias_personas_pedidas(n):
    personas = []

    for i in range(1, n+1):

        persona = persona_pedida(i)
        print(persona)
        personas.append(persona)

    return personas