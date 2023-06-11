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