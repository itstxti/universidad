""" 1. Para pedir a un usuario una fecha, vas a tener que pedirle 3 números enteros.
Cuando desees un número complejo le pedirás 2 enteros.
Cuando quieras que elija la opción de un menú, o el número de hijos le pedirás un entero.

El mensaje necesario y las condiciones límites son diferentes en cada caso,
pero el proceso de pedir un entero es siempre el mismo: 
muestras un mensaje con la pregunta al menos 1 vez, si el usuario introduce un valor inadecuado
(porque aborta o porque está fuera de los límites) se lo volverás a pedir,
hasta que te ofrezca un valor válido. Si el valor es válido, tu subprograma lo dejará a disposición de la memoria. 

Haz un solo subprograma que sirva para todos estos casos y muchos equivalentes."""

def entero_pedido(min, max, msg):
    pedir = True
    while  pedir or not (min<=n<=max):
        try: n = int(input(msg))
        except: print('Debe ser un entero. ')
        else: pedir = False        
    return n
 
# PROBADOR

min = 1
max = 12
print(entero_pedido(min, max, 'mes entre ' + str(min) + ' y ' + str(max) + ': '))