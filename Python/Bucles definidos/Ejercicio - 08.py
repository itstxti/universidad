""" 8. Construye un subprograma que devuelva la varianza de una población.
Reutiliza el subprograma media() que completaste antes."""

def media(lista):
    total = 0
    for i in lista:
        total += i
    return total / len(lista)


n = [4,1,3,5,11,2]

def varianza(lista):
    total = 0 
    for i in n:
        total += ((i -  media(n)) * (i -  media(n)))/len(n)
    return total

print(varianza(n))