"""9. Ten en cuenta que las estadísticas suelen realizarse con grandes volúmenes muestrales
y la memoria es siempre un bien escaso. Para algunas estadísticas no es necesario conservar
en memoria los datos concretos de las personas. En este ejercicio deseamos que, en la misma pasada
en que recibes los datos para cada uno de los encuestados, prepares el cálculo de la media de edad general,
la media por sexo, la cantidad de mujeres que tienen entre 13 y 16 años (ambos incluidos)
y el número de hombres (estrictamente) menores de 20 años. 
NOTAS: Acuérdate de programar de modo que sea fácil modificar los datos de tu enunciado
(es decir las edades relevantes y el número de personas). Atención porque, ocasionalmente,
podría todo el colectivo ser del mismo sexo."""

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


def persona_entre_edad(persona, min, max, sexo):

    if persona.sexo == sexo and max >= persona.edad >= min:
        return True
    return False


def persona_sexo(persona, sexo):
    if persona.sexo == sexo:
        return True
    return False


def varias_personas_pedidas(n):
    personas = []
    contador_mujeres_entre_edad = 0
    contador_hombres_entre_edad = 0
    total_edad = 0
    total_edad_m = 0
    total_edad_v = 0
    total_mujeres = 0
    total_hombres = 0

    for i in range(1, n+1):

        persona = persona_pedida(i)
        print(persona)
        total_edad += persona.edad

        if persona_sexo(persona, 'M'):
            total_edad_m += persona.edad
            total_mujeres += 1

        if persona_sexo(persona, 'V'):
            total_edad_v += persona.edad
            total_hombres += 1

        if persona_entre_edad(persona, 13, 16, 'M'):

            contador_mujeres_entre_edad +=1

        if persona_entre_edad(persona, 1, 20, 'V'):

            contador_hombres_entre_edad += 1

        personas.append(persona)

    if total_mujeres == 0:
        total_mujeres = 1
    if total_hombres == 0:
        total_hombres = 1

    return personas, contador_mujeres_entre_edad, contador_hombres_entre_edad, total_edad / len(personas), total_edad_m / total_mujeres, total_edad_v/ total_hombres



personas = varias_personas_pedidas(2)
for i in personas[0]:
    print(i)

print('EL NUMERO DE MUJERES QUE HAY ENTRE 13 Y 16 AÑOS SON', personas[1])
print('EL NUMERO DE HOMBRES MENORES DE 20 AÑOS SON', personas[2])
print('LA MEDIA DE EDAD ES', personas[3])
print('LA MEDIA DE EDAD DE LAS MUJERES ES', personas[4])
print('LA MEDIA DE EDAD DE LOS HOMBRES ES', personas[5])