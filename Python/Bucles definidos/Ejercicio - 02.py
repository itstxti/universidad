""" 2. Haz una función que tomé como argumento un número en cardinal y lo pase a texto."""


IRREGs=('uno','dos','tres','cuatro','cinco','seis','siete','ocho','nueve',\
     'diez','once','doce','trece','catorce','quince','dieciséis','diecisiete',\
     'dieciocho','diecinueve','veinte','veintiuno','veintidós','veintitrés',\
     'veinticuatro','veinticinco','veintiseis','veintisiete','veintiocho',\
     'veintinueve')


def enTextoNum(n):
    """int-->str
    OBJ: texto cardinal de n
    PRE: 1<=n<30. IRREGs definida"""
    return IRREGs[n-1]

print(enTextoNum(11))
print(enTextoNum(19))