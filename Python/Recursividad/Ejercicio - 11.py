""" 11. Realiza un programa que lea desde teclado un número entero positivo y
lo convierta a binario utilizando recursividad."""

def binario(numero):
    if numero == 0:
        return '0'
    elif numero == 1:
        return '1'
    else:
        return binario(numero // 2) + str(numero % 2)


# PROBRADOR

print(binario(4), 'es 100')
print(binario(3), 'es 11')

# PROGRAMA

try:
    numero = int(input("Ingresa un número entero positivo: "))
    resultado = binario(numero)
    print("El número en binario es:", resultado)
    
except: print('ERROR, el número introducido no es válido.')