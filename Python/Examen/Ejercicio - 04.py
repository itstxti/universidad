""" 4. La gestión de un concesionario de coches está informatizada porque
disponen de una gran cartera de clientes y un gran stock.
Para facilitar las búsquedas en la tabla de stock, los vehículos se encuentran ordenados por matrícula,
de cada vehículo nos interesa la matrícula, marca, modelo y precio,
los nuevos vehículos se insertan en su posición correspondiente.
El sistema también almacena los datos de los clientes que se han interesado por un vehículo,
de cada cliente se almacena nombre, apellidos, dirección y teléfono.
Un cliente puede estar interesado en varios coches (o ninguno aún),
y por un coche se pueden interesar varios clientes (o ninguno).
Cuando un coche se vende, desaparece del stock, sin embargo,
los datos de un cliente nunca desaparecen de sistema y su información se almacena en orden de aparición.
El 18 de septiembre de 2000 Tráfico instauró el actual sistema de matrículas,
que constan de cuatro dígitos y tres letras consonantes (suprimiéndose las cinco vocales, y las letras Ñ y Q).  
Las estructuras de datos diseñadas para la aplicación son:"""

from recordclass import recordclass

tCoche = recordclass('Coche', 'matricula marca modelo precio')
#tStock = lista [variable] de tCoche ordenados alfabéticamente
tCliente = recordclass('Cliente', 'nombre, apellidos, direccion, telefono')
#tClientes = lista[variable] de tCliente
tInteresado = recordclass('Interesado', 'coche, usuario')
	#coche es una matrícula, usuario es su posición en la lista de clientes.
#tInteresados = lista[variable] de tInteresado

# A. (3 puntos): Haga una función que localice y devuelva un coche del stock conocida su matrícula.
#Debe emplear el algoritmo más eficiente posible y justificar su elección.


def busqueda_matricula(stock, matricula):
    inicio = 0
    fin = len(stock)-1

    while inicio <= fin:
        mitad = (inicio + fin) // 2
        coche = stock[mitad]

        if matricula == coche.matricula:
            return mitad
        if matricula < coche.matricula:
            fin = mitad - 1
        else: inicio = mitad + 1
    return None

# PROBADOR

stock = [tCoche(matricula='4562CSD', marca='Toyota', modelo='Corolla', precio=25000), 
        tCoche(matricula='8095HGM', marca='Ford', modelo='Mustang', precio=45000),
        tCoche(matricula='8156DFB', marca='Honda', modelo='Civic', precio=22000),
        tCoche(matricula='9156GGB', marca='Chevrolet', modelo='Camaro', precio=48000),
        tCoche(matricula='9959YJN', marca='Volkswagen', modelo='Golf', precio=20000)]


print(busqueda_matricula(stock, '4562CSD'), 0)
print(busqueda_matricula(stock, '8156DFB'), 2)
print(busqueda_matricula(stock, '9959YJN'), 4)
print(busqueda_matricula(stock, '1111YJN'), 'None')



# B. (2 puntos): Diseñe un algoritmo recursivo que, dada la lista de interesados y una matrícula,
#muestre los datos de cada cliente interesado en ese vehículo.


clientes = [tCliente('JUAN', 'GARCIA', 'CALLE X', '972833829'),
            tCliente('MARIA', 'FERNANDEZ', 'CALLE Y', '8574185861'),
            tCliente('PEPE', 'GONZALEZ', 'CALLE Z', '8916513796'),
            tCliente('FRAN', 'LOPEZ', 'CALLE R', '308U3241'),
            tCliente('LUCIA', 'MARTINEZ', 'CALLE T', '463241232')]


interesados = [tInteresado('4562CSD', 0),
               tInteresado('8095HGM', 1),
               tInteresado('9959YJN', 2),
               tInteresado('4562CSD', 3),
               tInteresado('8156DFB', 4)]


def mostrar_interesados(lista, matricula, index = 0):
    if index < len(lista):
    
        if lista[index].coche == matricula:
            print(clientes[index])

        mostrar_interesados(lista, matricula, index + 1)


# PROBADOR

print(mostrar_interesados(interesados, '9959YJN'))
print(mostrar_interesados(interesados, '8888YJN')) 


# C. (2 puntos): Haga una función que reciba una cadena de texto y devuelva si es una matrícula válida o no.


def matricula_valida(matricula):
    matricula = matricula.upper()
    
    if len(matricula) != 7: # TIENE QUE TENER 7 CARACTERES
        return False
    
    contador_letras = 0
    contador_numeros = 0

    letras_posibles = 'WRTYPSDFGHJKLZXCVBNM'
    numeros_posibles = '0123456789'
                        
    for i in range(0, 4): # LAS CUATRO PRIMEROS CARACTERES TIENEN QUE SER NUMEROS
        if matricula[i] in numeros_posibles:
            contador_numeros +=1
    
    for i in range(4, 7): # LOS ULTIMOS TRES CARACTERES TIENEN QUE SER LETRAS
        if matricula[i] in letras_posibles:
            contador_letras += 1
        
    return contador_letras == 3 and contador_numeros == 4

# PROBADOR

print(matricula_valida('4545YJN'), 'TRUE')
print(matricula_valida('YJN4545'), 'FALSE')
print(matricula_valida('45455JN'), 'FALSE')
print(matricula_valida('4545AJN'), 'FALSE')
print(matricula_valida('4545FAJN'), 'FALSE')

# D. (3 puntos): Haga un subprograma que devuelve una matrícula solicitada al usuario (pedida tantas veces como sea necesario).

def matricula_pedida(msg):
    a = input(msg)
    if not matricula_valida(a):
        a = input(msg)
    return a.upper()

# PROBADOR

print(matricula_pedida('INTRODUCE UNA MATRICULA: '))