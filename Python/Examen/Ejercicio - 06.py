"""Una empresa nos ha encargado el diseño y realización de una aplicación informática que permita
buscar productos en su base de datos. La empresa dispone de una lista de productos, donde
para cada producto se almacena su nombre, categoría, precio, stock y una lista de palabras clave.
Se pide implementar: [3 puntos]"""

productos = [{'nombre': "Iphone 14", 'categoria': 'movil', 'clave': ['5g', 'iphone', 'apple'], 'precio': 600, 'stock': 100},
             {'nombre': "Altavoz JBL Flip 4", 'categoria': 'altavoz', 'clave': [
                 'flip', 'bluetooth', 'JBL'], 'precio': 100, 'stock': 50},
             {'nombre': "Xiaomi 13T", 'categoria': 'movil', 'clave': [
                 '5g', 'xiaomi', '13t'], 'precio': 400, 'stock': 200},
             {'nombre': "Apple Watch 8", 'categoria': 'reloj', 'clave': [
                 'nfc', 'apple', 'watch'], 'precio': 400, 'stock': 100},
             {'nombre': "Samsung Watch", 'categoria': 'reloj', 'clave': [
                 'nfc', 'samsung', 'watch'], 'precio': 200, 'stock': 100},
             {'nombre': "Nintendo Switch", 'categoria': 'consola', 'clave': [
                 'nintendo', 'switch', 'oled'], 'precio': 300, 'stock': 200},
             {'nombre': "Alexa Echo Show 8", 'categoria': 'altavoz', 'clave': [
                 'alexa', 'show', 'bluetooth'], 'precio': 150, 'stock': 100},
             {'nombre': "Mi Smart Band 6", 'categoria': 'reloj', 'clave': [
                 'bluetooth', 'xiaomi', 'smartband'], 'precio': 40, 'stock': 100},
             {'nombre': "Samsung S22", 'categoria': 'movil', 'clave': [
                 '5g', 'samsung', 's22'], 'precio': 600, 'stock': 100},
             {'nombre': "Playstation 5", 'categoria': 'consola', 'clave': [
                 'playstation', 'hdmi', 'sony'], 'precio': 800, 'stock': 100},
             {'nombre': "Apple Airpods 14", 'categoria': 'altaoz', 'clave': ['apple', 'airpods', 'bluetooth'], 'precio': 400, 'stock': 50}]

"""1. Una función que reciba una lista de productos y una categoría y devuelva una lista con los
productos que pertenecen a esa categoría. (1 punto)"""

def lista_categoria(lista, categoria):
    lista_categoria = []
    for producto in lista:
        if producto["categoria"] == categoria:
            lista_categoria.append(producto)
    return lista_categoria

#PROBADOR
print(lista_categoria(productos, "movil"))

"""2. Una función que reciba una lista de productos y una palabra clave y devuelva una lista con
los productos que tienen esa palabra clave. (1 punto)"""

def lista_palabra_clave(lista, palabra):
    lista_palabra_clave = []
    for producto in lista:
        for clave in producto["clave"]:
            if clave == palabra:
                lista_palabra_clave.append(producto)
    return lista_palabra_clave

# PROBADOR
print(lista_palabra_clave(productos, "samsung"))

"""3. Una función que permita filtrar la lista de productos por una categoría y una palabra clave.
La función debe reutilizar las funciones de los apartados anteriores y devolver una lista con
los productos que pertenecen a esa categoría y contienen esa palabra clave, sin repetir. (1
punto)"""

def lista_palabra_categoria(clave, categoria, lista):
    lista_palabra_categoria = []
    lista_clave = lista_palabra_clave(lista, clave)
    lista_cat = lista_categoria(lista, categoria)
    if len(lista_cat)>len(lista_clave):
        for producto in lista_cat:
            if producto in lista_clave:
                lista_palabra_categoria.append(producto)
    else:
        for producto in lista_clave:
            if producto in lista_cat:
                lista_palabra_categoria.append(producto)
    return lista_palabra_categoria

#otra forma
def lista_palabra_categoria2(clave, categoria, lista):
    lista_clave = lista_palabra_clave(lista, clave)
    lista_palabra_categoria = lista_categoria(lista_clave, categoria)
    return lista_palabra_categoria


#PROBADOR
print(lista_palabra_categoria2("samsung", "movil", productos))