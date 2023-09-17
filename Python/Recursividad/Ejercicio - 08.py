""" 8. Programa una función que, dada una palabra, retorne la misma invertida utilizando recursividad."""

def palabra_inversa(p):
    if len(p) == 1:
        return p
    else:
        return p[len(p)-1] + palabra_inversa(p[0: len(p)-1])
    

# PROGRAMA

try:
    palabra = input('Introduce una palabra: ')
    print(palabra_inversa(palabra))
except: print('Error, la palabra introducido no es válida.')