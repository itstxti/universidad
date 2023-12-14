"""12. Realizar un programa que lea palabras hasta que se introduzca “fin”, mostrando
un recuento de las longitudes de las palabras, es decir, el número total de
palabras de longitud 1 que se hayan introducido, el total de longitud 2, etc. Una posible salida
de este programa sería:
Palabras longitud 1: ninguna
Palabras longitud 2: 10
…
Palabras longitud 15: 1"""

def longitud_palabra(palabra):
    contador = 0
    for i in palabra:
        contador += 1
    
    return contador

# PROGRAMA PRINCIPAL

palabra = ""
contador = 1
while palabra != "fin":
    palabra = input("Introduce una palabra: ")
    print("Palabras longitud", contador, ":", longitud_palabra(palabra))
    contador +=1

