"""7. Colegios de diferentes partes de España participan en una determinada competición donde cada colegio ha de
realizar tres pruebas. La competición se organiza en diferentes ciudades (sedes) en las que compiten una serie
de colegios. Para cada colegio se registra su nombre, ciudad en la que se ubica y la puntuación obtenida en las
tres pruebas.
Las estructuras que se deben manejar son las siguientes:"""

sedes = {'Madrid': ['Santo Domingo', 'Buen Amor', 'Virgen de Covadonga'],
         'Burgos': ['El Cid Campeador', 'Infanta Doña Sol', 'Merindades', 'Río Duero']}

colegios = [{'nombre': 'Santo Domingo', 'ciudad': 'Madrid', 'puntuaciones': [60, 65, 30]},
            {'nombre': 'Infanta Doña Sol', 'ciudad': 'Soria',
                'puntuaciones': [27, 40, 20]},
            {'nombre': 'El Cid Campeador', 'ciudad': 'Burgos',
                'puntuaciones': [40, 35, 35]},
            {'nombre': 'Buen Amor', 'ciudad': 'Toledo',
                'puntuaciones': [49, 50, 25]},
            {'nombre': 'Virgen de Covadonga', 'ciudad': 'Madrid',
             'puntuaciones': [55, 30, 25]},
            {'nombre': 'Merindades', 'ciudad': 'Burgos',
                'puntuaciones': [48, 33, 30]},
            {'nombre': 'Río Duero', 'ciudad': 'Burgos', 'puntuaciones': [40, 30, 15]}]

""" Se pide:
a) 1 punto. Devolver la sede donde menos colegios hayan participado y cuántos colegios participaron en dicha
sede.
Basándonos en el ejemplo de inicialización que se proporciona al comienzo de este enunciado, se muestra
a continuación una posible llamada a esta función, indicando el valor que devolvería en cursiva:

print(sede_menos_colegios(sedes))
('Madrid', 3)"""

def sede_menos_colegios(sedes):
    """dict--> tupla
    OBJ: Devolver la sede donde menos colegios hayan participado"""
    min=1000
    for sede in sedes:
        if len(sedes[sede])<min:
            s=sede
            min=len(sedes[sede])
    return s,min

print(sede_menos_colegios(sedes))

"""b) 1 punto Ordenar alfabéticamente la lista de colegios por la ciudad en la que están.
Basándonos en el ejemplo de inicialización que se proporciona al comienzo de este enunciado, se muestra
a continuación una posible llamada a esta función, indicando el valor que devolvería en cursiva: """

def ordenar_por_ciudad(colegios):
    """list-->list
    OBJ: Ordena los colegio por la ciudad en la que están."""
    for i in range(len(colegios)-1):
        min_index = i
        for j in range(i+1, len(colegios)):
            if colegios[j]['ciudad'] < colegios[min_index]['ciudad']:
                min_index = j
                colegios[i], colegios[min_index] = colegios[min_index], colegios[i]
    return colegios
            

print(ordenar_por_ciudad(colegios))

"""3 puntos A partir de un texto (por ejemplo una reseña en un periódico), crear un diccionario que contenga
el número de veces que aparece la ciudad de los colegios de la competición en el texto y mostrar esas
frecuencias en un histograma.
Para el texto:"""

texto = "Los colegios de Madrid demostraron un nivel muy alto, aunque los de Toledo les pisaban los talones. Soria se quedó un poco rezagada y Burgos demostró un gran nivel también. Tendremos que esperar para ver quién gana la final, pero el colegio Sto. Domingo de Madrid es un firme candidato. Por su parte, Merindades, de Burgos y Virgen de Covadonga, de Madrid, están muy empatados."


def extraer_ciudad(palabra, lista_ciudades):
    ciudad = ''

    if palabra in lista_ciudades:
        ciudad = palabra
    elif palabra[:len(palabra)-1] in lista_ciudades:
        ciudad = palabra[:len(palabra)-1]
    elif palabra[1:len(palabra)-1] in lista_ciudades:
        ciudad = palabra[1:len(palabra)-1]
    elif palabra[1:] in lista_ciudades:
        ciudad = palabra[1:]

    return ciudad


def generar_histograma(texto, colegios):
    palabras = texto.split()
    h = {}
    lista_ciudades = []

    for colegio in colegios:
        if not colegio['ciudad'] in lista_ciudades:
            lista_ciudades.append(colegio['ciudad'])

    for palabra in palabras:
        ciudad = extraer_ciudad(palabra, lista_ciudades)
        if ciudad != '':
            if ciudad in h.keys():
                h[ciudad] += 1
            else:
                h[ciudad] = 1

    return h


def mostrar_histograma(h):
    for k, v in h.items():
        print(k, '|', '*' * v)


hist = generar_histograma(texto, colegios)
mostrar_histograma(hist)

"""3 puntos. Sabiendo que la puntuación final de cada colegio es la suma de las puntuaciones que ha obtenido
en las tres pruebas, programar una solución recursiva que devuelva la mejor puntuación final de la
competición.
Para el ejemplo anterior, la mejor puntuación final es 155, que se corresponde con la suma de las
puntuaciones del colegio Sto. Domingo. Se debe proporcionar únicamente la puntuación final, no el colegio
al que le corresponde.
Basándonos en el ejemplo de inicialización que se proporciona al comienzo de este enunciado, se muestra
a continuación una posible llamada a esta función, indicando el valor que devolvería en cursiva:"""

def puntuacion(l):
    """list --> int
    OBJ: suma los elementos de una lista"""

    if l == []:
        resultado = 0
    else:
        resultado = l[0] + puntuacion(l[1:])
    return resultado

def mejor_puntuacion(colegios, ini, fin):
    """dict, int, int --> int
    OBJ: devolver el nombre y la puntuación total del mejor colegio"""

    if ini > fin:
        mejor = 0
    else:
        puntos_actuales = puntuacion2(colegios[ini]['puntuaciones'])
        mejor = max(puntos_actuales, mejor_puntuacion(colegios, ini + 1, fin))
    return mejor

# OTRA FORMA

def puntuacion2(l):
    total = 0
    for i in l:
        total += i
    return total

def mejor_puntuacion2(colegios, ini, fin):
    max = 0
    for i in range(ini, fin):
        puntos = puntuacion2(colegios[i]['puntuaciones'])
        if puntos > max:
            max = puntos
    return max

print(mejor_puntuacion2(colegios, 0, len(colegios)-1))

"""3 puntos Devolver una lista con los finalistas de cada sede, es decir, con los colegios que mayor puntuación
han obtenido en cada sede.
Basándonos en el ejemplo de inicialización que se proporciona al comienzo de este enunciado, se muestra
a continuación una posible llamada a esta función, indicando el valor que devolvería en cursiva:"""


def buscar_colegio(colegios, colegio):
    """list, string --> int
    OBJ: Obtiene la posición dentro de la lista del colegio que se pasa como parámetro"""

    enc = False
    i = 0

    while not enc and i < len(colegios):
        if colegios[i]['nombre'] == colegio:
            enc = True
        else:
            i += 1

    if enc:
        pos = i
    else:
        pos = -1

    return pos


def lista_finalistas(colegios, sedes):
    """dict, list --> list
    OBJ: Devuelve una lista con el nombre de los colegios que han ganado en cada sede"""

    finalistas = []

    for sede in sedes.keys():
        max_puntos = -1

        for colegio in sedes[sede]:
            pos = buscar_colegio(colegios, colegio)
            puntos = puntuacion(colegios[pos]['puntuaciones'])

            if max_puntos < puntos:
                max_puntos = puntos
                nombre = colegios[pos]['nombre']

        finalistas.append(nombre)

    return finalistas


print(lista_finalistas(colegios, sedes))
# La salida deberia ser: ['Santo Domingo', 'Merindades']