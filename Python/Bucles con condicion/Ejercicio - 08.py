""" 8. El Documento Nacional de Identidad (DNI) español está compuesto por un número de 8 dígitos, y una letra.
Haz un subprograma que indique si un DNI es válido. 
Haz un programa que solicita a un usuario el DNI, hasta que introduzca un DNI válido. 
Se divide el número entre 23 y el resto se sustituye por una letra de la siguiente tabla:

RESTO	0	1	2	3	4	5	6	7	8	9	10	11
LETRA	T	R	W	A	G	M	Y	F	P	D	X	B
 

RESTO	12	13	14	15	16	17	18	19	20	21	22
LETRA	N	J	Z	S	Q	V	H	L	C	K	E

"""

def validar_dni(numeros, letra):
    
    if len(str(numeros)) != 8:
        return False

    resto = numeros % 23
    letras = 'TRWAGMYFPDXBNJZSQVHLCKE'

    for i in range(len(letras)):
        if resto == i and letra.upper() == letras[i]:
            return True
    
    return False


def pedir_dni():
    try: 
        numeros = int(input('INTRODUCE LOS NUMEROS DE TU DNI: '))
        letra = input('INTRODUCE LA LETRA DE TU DNI: ')
        if validar_dni(numeros, letra) == True:
            print('TU DNI ES VALIDO.')
        else:
            print('INTRODUCE DATOS VALIDOS.')
            pedir_dni()
    except:
        print('INTRODUCE DATOS VALIDOS.')
        pedir_dni()

pedir_dni()