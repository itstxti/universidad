""" 11. Dado un número en base decimal y una base menor que diez,
escribir un programa que cambie dicho número a la base dada utilizando para ello un procedimiento recursivo."""


# IGUAL QUE CAMBIAR A BINARIO

def convertir_base(numero, base):
    if numero < base:
        return str(numero)
    else:
        return convertir_base(numero // base, base) + str(numero % base)


# PROBADOR

print(convertir_base(5, 3), '=', 12)
print(convertir_base(3, 5), '=', 3)