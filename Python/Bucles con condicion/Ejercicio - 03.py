""" 3. Los siguientes códigos no hacen lo que se deseaba que hicieran, por lo menos, no siempre.
Corrígelos y explica el motivo."""

"""

#1 Son las doce de la noche y estás cansadísimo

resp=''    #forzar la entrada a bucle
while resp!='si' or resp!='no':  
    #los humanos nos confundimos con las dobles negaciones
    resp=input('¿tienes hambre?: ')
if resp=='si': print('cena')
else: print('a la cama')
"""

resp=''
while resp !='no' and resp != 'si':
    resp=input('¿tienes hambre?: ')
if resp == 'si':
    print('cena')
else:
    print('a la cama')

"""

#2 

def n_pares_ini(sec):
    sec de num --> int
    OBJ: numero elementos pares hay hasta primer impar
    cont=0
    pos=0
    while sec[pos]%2!=1 and pos<=len(sec):
        cont+=1
        pos+=1
    return cont

"""

def n_pares_ini(sec):
    """sec de num --> int
    OBJ: numero elementos pares hay hasta primer impar"""
    cont=0
    pos=0
    while pos<len(sec) and sec[pos]%2==0:
        cont+=1
        pos+=1
    return cont

#PROBADOR
ejemplo= (2,4,8,1)
print(n_pares_ini(ejemplo), 3)
print(n_pares_ini([0,2,3,4]), 2) 
print(n_pares_ini([2,4,6,8]), 4)
print(n_pares_ini([]), 0)