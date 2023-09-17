""" 2. En una aplicación de gestión de ventas se mantiene información acerca de diversos productos,
de cada uno de los cuales se almacena su código (una cadena de caracteres alfanumérica de 8 cifras,
única para cada producto), nombre, precio, y existencias disponibles.
El número de productos ha crecido rápidamente en los últimos años,
por lo que se hace muy interesante el poder realizar búsquedas de forma más eficiente.
Suponiendo que existe una función que ordena la lista por código de manera descendente,
implementa una función de búsqueda eficiente para encontrar un producto por su código. [2 puntos]"""

from recordclass import recordclass

tProducto = recordclass('Producto', 'codigo, nombre, precio, existencias')

p1 = tProducto('12345678', 'PASTA', 12.8, 23)
p2 = tProducto('23458951', 'CARNE', 12.8, 23)
p3 = tProducto('34567890', 'PESCADO', 12.8, 23)
p4 = tProducto('41958925', 'FRUTA', 12.8, 23)
p5 = tProducto('51951894', 'VERDURA', 12.8, 23)

productos = []
productos.append(p5)
productos.append(p4)
productos.append(p3)
productos.append(p2)
productos.append(p1)

# 5,4,3,2,1

def busqueda_binaria(codigo, lista):
    inicio = 0
    fin = len(lista) - 1

    while inicio <= fin:
        mitad = (inicio + fin) // 2
        elemento = lista[mitad]

        if codigo == elemento.codigo:
            return elemento
        elif codigo < elemento.codigo:
            inicio = mitad + 1

        else:
            fin = mitad - 1

    return None

print(busqueda_binaria('51951894', productos))