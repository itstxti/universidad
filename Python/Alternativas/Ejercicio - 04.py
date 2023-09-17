""" 4. Haz un programa que pida al usuario un año, si lo introducido es posterior a 1582
imprimirá si es bisiesto, si no, explicará el motivo."""

def es_bisiesto(año):
    if año % 4 == 0:
        if año % 100 != 0 or año % 400 == 0:
            return True
    return False

# PROGRAMA

año = int(input("Introduce un año: "))

if año > 1582:
    if es_bisiesto(año):
        print("El año", año, "es bisiesto.")
    else:
        print("El año", año, "no es bisiesto.")
else:
    print("El año debe ser posterior a 1582 para determinar si es bisiesto.")