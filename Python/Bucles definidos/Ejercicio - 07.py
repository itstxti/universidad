""" 7. Haz una función que calcule la media."""

def media(lista):
    total = 0
    for i in lista:
        total += i
    return total / len(lista)

print(media([2,4,6]), 'es', (2+4+6)/3)