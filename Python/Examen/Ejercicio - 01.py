""" 1. Se desea desarrollar un software para la gestión de la venta de mascarillas EPI en un establecimiento
farmacéutico. Se pide:""" 

""" A. Define una estructura de datos que permita almacenar información acerca de una mascarilla.
Se debe almacenar el modelo (un entero entre 1000 y 2000), tipo de mascarilla (FFP1, FFP2 y FFP3),
color, precio y unidades disponibles. Genera además una lista con 50 modelos de tipo mascarilla
(para el modelo se recomienda generar un núm ero aleatorio). [0,5 puntos]"""


from recordclass import recordclass
from random import randint

tMascarilla = recordclass('Mascarilla', 'modelo, tipo, color, precio, unidades' )
tipos_mascarillas = ['FFP1', 'FFP2', 'FFP3']
colores_disponibles = ['ROJO', 'VERDE', 'AZUL', 'AMARILLO', 'NARANJA', 'MORADO', 'BLANCO', 'NEGRO', 'GRIS', 'ROSA']

def crear_mascarillas(n):
    mascarillas = []

    for i in range(n):
        modelo = randint(1000, 2000)
        tipo = tipos_mascarillas[randint(0, 2)]
        color = colores_disponibles[randint(0, 9)]
        if tipo == 'FFP1': precio = 8.5
        if tipo == 'FFP2': precio = 9.5
        if tipo == 'FFP3': precio = 10.5
        unidades = randint(1, 100)

        mascarilla = tMascarilla(modelo, tipo, color, precio, unidades)
        mascarillas.append(mascarilla)

    return mascarillas


""" B. Programa un procedimiento que muestre por pantalla el stock disponible de un cierto tipo
(deberá incluir todos los modelos y unidades de dicho tipo). [1 punto]"""


def contar_tipos(tipo, mascarillas):
    contador = 0

    for i in mascarillas:
        if i.tipo == tipo:
             contador += 1

    return contador


""" C. Implementa un subprograma que permita realizar la venta de una mascarilla tomando
como entrada el tipo de mascarilla y el número de unidades deseadas por el cliente.
Si hay existencias, se mostrarán los distintos modelos de dicho tipo disponibles junto
con las unidades de cada modelo y se le pedirá al usuario que elija un modelo de los disponibles.
Una vez elegido, se hará efectiva la compra, que actualizará el número de unidades existentes y
mostrará un mensaje indicando el importe a pagar. Si no hay existencias suficientes para satisfacer
el deseo del cliente, se mostrará un mensaje indicando que no se produjo la venta. [1,5 puntos]"""


def mascarilla_tipo(tipo, mascarillas):
    mascarillas_deseadas = []
    for i in mascarillas:
        if i.tipo == tipo:
            mascarillas_deseadas.append(i)
    return mascarillas_deseadas


def comprar(tipo, unidades_deseadas):
    if contar_tipos(tipo, mas) < unidades_deseadas:
        print('NO HAY UNIDADES SUFICIENTES.')
    else:
        mascarillas_deseadas = mascarilla_tipo(tipo, mas)
        for i in range(len(mascarillas_deseadas)):
            print(i+1, mascarillas_deseadas[i])
        try:
            n = int(input('INTRODUCE QUE MODELO DE MASCARARILLA QUIERE.\n'))
            if mascarillas_deseadas[n-1].unidades >  unidades_deseadas:
                print('GRACIAS POR COMPRAR EL MODELO', mascarillas_deseadas[n-1].modelo,'EL PRECIO ES DE:', mascarillas_deseadas[n-1].precio*unidades_deseadas)
                for i in mas:
                    if i == mascarillas_deseadas[n-1]:
                        i.unidades = i.unidades - unidades_deseadas
                    
            else: print('NO HAY UNIDADES SUFICIENTES.')
        except: print('INTRODUCE UNA OPCIÓN VALIDA')


""" D. Implementa una función que retorne una lista con todos los modelos de mascarillas
que se deben reponer en la tienda. Se deben reponer todas aquellas mascarillas de las que
haya menos de 100 unidades.  [1,5 puntos]"""


def cuales_reponer(n, mascarillas):
    mascarillas_reponer = []
    for i in mascarillas:
        if i.unidades < n:
            mascarillas_reponer.append(i)
    return mascarillas_reponer


""" E. Implementa un subprograma que permita reponer las mascarillas procedentes del distribuidor.
Para ello, se tomará como entrada una lista de tuplas con modelos de mascarillas y
la cantidad recibidas de cada una, con la que se actualizará el inventario de la tienda. [1,5 puntos]"""


def reponer(mascarillas):
    for mascarilla in mascarillas:
        for j in range(len(mas)):
            if mascarilla[0].modelo == mas[j].modelo:
                mas[j].unidades = mas[j].unidades + mascarilla[1]
                print('SE HAN REPUESTO', mascarilla[1], 'DE EL MODELO: ',mas[j].modelo)
    

def cantidad_mascarillas_reponer(lista, unidades_minimas):
    mascarillas_para_reponer = []
    for i in lista:
        mascarilla = [i, unidades_minimas-i.unidades]
        mascarillas_para_reponer.append(mascarilla)
    return mascarillas_para_reponer


# PROBADOR

mas = crear_mascarillas(50) # SE CREAN LAS MASCARILLAS

for i in mas: # SE IMPRIMEN UNA A UNA
    print(i)

comprar('FFP1', 10)  # SE INTENTA COMPRAR 10 DE FFP1

unidades_minimas = 100 # LAS UNIDADES MINIMAS QUE TIENE QUE TENER CADA MODELO

# SE CREA LA LISTA DE MASCARILLAS QUE HAY QUE REPONER
# (TODAS LAS QUE NO TIENEN MENOS UNIDADES QUE LAS UNIDADES MINIMAS)

mascarillas_reponer = cuales_reponer(unidades_minimas, mas)

# SE IMPRIMEN CUANTAS UNIDADES HAY QUE REPONER DE CADA MODELO HASTA LLEGAR A LAS UNIDADES MINIMAS
for i in mascarillas_reponer:
    print(i)
    print('HAY QUE REPONER:', unidades_minimas-i.unidades, 'UNIDADES.')

reponer(cantidad_mascarillas_reponer(mascarillas_reponer, unidades_minimas)) # SE REPONEN

for i in mas: # SE IMPRIMEN UNA A UNA OTRA VEZ PARA COMPROBAR QUE SE HAN REPUESTO BIEN
    print(i)