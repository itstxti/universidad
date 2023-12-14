"""15. Realiza una aplicación que permita sumar dos matrices de tamaño 3x4. Las matrices
contienen datos sobre Puntos2D. Debe hacer las siguientes tareas:
a. Solicitar datos para la matriz A.
b. Solicitar datos para la matriz B.
c. Presentar el resultado de matriz A + matriz B"""

def pedir_matriz():
    matriz = {}
    for i in range(1, 4):
        for j in range(1, 4):
            n = f"{i}x{j}"
            matriz[n] = int(input(f"Introduce el número {n}: "))
    return matriz


def sumar_matrices(m1, m2):
    resultado = {}
    for i in range(1, 4):
        for j in range(1, 4):
            n = f"{i}x{j}"
            resultado[n] = m1[n] + m2[n]
    return resultado


# Pedir datos para las matrices
matriz1 = pedir_matriz()
print("Matriz 1:", matriz1)

matriz2 = pedir_matriz()
print("Matriz 2:", matriz2)

# Sumar las matrices y mostrar el resultado
resultado_suma = sumar_matrices(matriz1, matriz2)
print("Resultado de la suma:", resultado_suma)

#VERSION SIN DICCIONARIOS

def pedir_matriz():
    matriz = []
    for i in range(3):
        fila = []
        for j in range(3):
            fila.append(int(input(f"Introduce el número {i+1}x{j+1}: ")))
        matriz.append(fila)
    return matriz


def sumar_matrices(m1, m2):
    resultado = []
    for i in range(3):
        fila_resultado = []
        for j in range(3):
            suma_elemento = m1[i][j] + m2[i][j]
            fila_resultado.append(suma_elemento)
        resultado.append(fila_resultado)
    return resultado


# Pedir datos para las matrices
matriz1 = pedir_matriz()
print("Matriz 1:")
for fila in matriz1:
    print(fila)

matriz2 = pedir_matriz()
print("Matriz 2:")
for fila in matriz2:
    print(fila)

# Sumar las matrices y mostrar el resultado
resultado_suma = sumar_matrices(matriz1, matriz2)
print("Resultado de la suma:")
for fila in resultado_suma:
    print(fila)