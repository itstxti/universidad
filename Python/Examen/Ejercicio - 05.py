"""5. Cada año en época de cría, las tortugas marinas depositan sus huevos en la playa. A los 60 días,
cuando los huevos eclosionan, las crías deben correr hacia el mar intentando escapar de sus
depredadores (principalmente aves y cangrejos). Completa los siguientes apartados: [7 puntos]"""

"""A. Crea una estructura para almacenar los datos de 1000 crías de tortuga. De cada tortuga se
desea guardar un identificador, su velocidad media y la distancia que le queda para llegar
al mar. La velocidad media debe ser un valor aleatorio comprendido entre 0,30 y 0,60 m/s.
La distancia hasta el mar será otro valor aleatorio entre 50 y 200 metros. (1 punto)"""

import random

def crear_tortuga(id, velocidad, distancia):
    return {"id": id, "velocidad": velocidad, "distancia": distancia}

def crear_lista_tortugas():
    tortugas = []
    for i in range(100):
        velocidad = random.randint(3, 6)/10
        distancia = random.randint(50, 200)
        tortuga = crear_tortuga(i, velocidad, distancia)
        tortugas.append(tortuga)
    return tortugas


"""B. Implementa un subprograma para avanzar las crías hacia el mar. El subprograma recibe un
entero con los segundos que avanzan todas las crías sin recibir ataques. Dependiendo de la
velocidad de cada cría, se restará la distancia correspondiente a cada una de ellas. (1 punto)"""

def avanzar_tortuga(n, tortugas):
    for tortuga in tortugas:
        velocidad = tortuga["velocidad"]
        tortuga["distancia"] = tortuga["distancia"] - n*velocidad


"""C. Implementa un subprograma para eliminar las crías de tortuga que han llegado al mar. La
función debe eliminar las crías correspondientes de la estructura e imprimir por cada una
de ellas la frase “La cría {id} ha llegado al mar”. Devolverá un contador con cuantas crías se
han salvado. (2 puntos)"""


def tortugas_a_salvo(lista):
    contador = 0
    for pos in range(len(lista) - 1, -1, -1):
        tortuga = lista[pos]
        if tortuga["distancia"] <= 0:
            lista.pop()
            id = tortuga["id"]
            print(f"La cría {id} ha llegado al mar")
            contador += 1
    return contador


"""D. Implementa un subprograma para simular los ataques de los depredadores, que reciba un
entero con el número de depredadores que van a atacar en ese momento. Los ataques
tienen una probabilidad de éxito del 50%. Se seleccionará una cría aleatoria de la estructura
y si el ataque ha tenido éxito, se mostrará la frase “La cría {id} ha muerto”, eliminándola de
la estructura. (2 puntos)"""

def atacar_tortugas(tortugas, n):
    for i in range(0, n):
        if len(tortugas) > 0:
            pos = random.randint(0, len(tortugas)-1)
            exito = random.randint(0, 1)
            if exito == 0:
                id = tortugas[pos]["id"]
                print("La cría", id,  "ha muerto")
                tortugas.pop(pos)


"""E. En el programa principal se hará la simulación. Mientras queden crías de tortuga en la
estructura, se simulará el ataque de 30 depredadores y las crías avanzarán 10 segundos sin
recibir ningún ataque. Posteriormente, se eliminarán las crías que han llegado al mar y se
repetirá el mismo proceso. El programa debe imprimir al final el número total de crías que
se han salvado. (1 punto)"""

# PROGRAMA PRINCIPAL

tortugas = crear_lista_tortugas()
print(tortugas)
salvadas = 0
while len(tortugas) > 0:
    atacar_tortugas(tortugas, 30)
    avanzar_tortuga(10, tortugas)
    salvadas += tortugas_a_salvo(tortugas)

print("Se han salvado un total de", salvadas, "tortuga(s)")