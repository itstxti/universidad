""" 1. Haz un subprograma que escriba el nombre de un número cardinal, comprendido entre 30 y 99."""

def muestra_cardinal(n):
    if n >= 90:
        print('noventa', end='')
    elif n >= 80:
        print('ochenta', end='')
    elif n >= 70:
        print('setenta', end='')
    elif n >= 60:
        print('sesenta', end='')
    elif n >= 50:
        print('cincuenta', end='')
    elif n >= 40:
        print('cuarenta', end='')
    elif n >= 30:
        print('treinta', end='')
        
    n = n % 10

    if n == 1:
        print(' y uno')
    elif n == 2:
        print(' y dos')
    elif n == 3:
        print(' y tres')
    elif n == 4:
        print(' y cuatro')
    elif n == 5:
        print(' y cinco')
    elif n == 6:
        print(' y seis')
    elif n == 7:
        print(' y siete')
    elif n == 8:
        print(' y ocho')
    else:
        print(' y nueve')


muestra_cardinal(67)
muestra_cardinal(90)