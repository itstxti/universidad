## Implementa una función "fuerza" que retorne el valor de la magnitud física
## fuerza a partir de los valores de masa y aceleración recibidos como
## parámetros. Construye después un programa probador especificando los
## casos de prueba necesarios que muestre por pantalla el valor de la fuerza a
## partir de una masa y aceleración dadas.

def fuerza(masa, aceleracion):
    """ float, float --> float 
    OBJ: calcular fuerza
    PRE: 
    """
    return masa*aceleracion

# PROBADOR

print(fuerza(35, 3.42))