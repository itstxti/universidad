def contar_digitos(n):
    if n == 0:
        return 1
    if n < 10:
        return 1
    else:
        return 1 + contar_digitos(n//10)

# PROBADOR

print(contar_digitos(0), 'debe ser 1')
print(contar_digitos(1234), 'debe ser 4')

# PROGRAMA

try:
    n = int(input("Ingresa un número entero: "))
    resultado = contar_digitos(n)
    print("El número de dígitos es:", resultado)

except:
    print('ERROR, el número introducido no es válido.')



