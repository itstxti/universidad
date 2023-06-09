""" 9. Realiza una función recursiva que, dado un número entero, cuente su número de dígitos."""

def contar_digitos(n):
    if len(n) == 1:
        return 1
    else:
        return 1 + contar_digitos(n[1:len(n)])
    
try:
    n = int(input("Introduce un número: ")) # solo acepta numeros
    print(contar_digitos(str(n))) # vuele a transformarlo en str
except: print('ERROR, el número introducido no es válido.')

