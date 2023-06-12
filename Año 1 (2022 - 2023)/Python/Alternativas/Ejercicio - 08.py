def calcular_tiempo_trabajado(entrada, salida):
    horas_entrada, minutos_entrada = entrada
    horas_salida, minutos_salida = salida

    if horas_entrada <= horas_salida:
        horas_trabajadas = horas_salida - horas_entrada
        minutos_trabajados = minutos_salida - minutos_entrada
    else:
        horas_trabajadas = (24 - horas_entrada) + horas_salida
        minutos_trabajados = minutos_salida - minutos_entrada

    if minutos_trabajados < 0:
        minutos_trabajados += 60
        horas_trabajadas -= 1

    if horas_trabajadas > 8 or (horas_trabajadas == 8 and minutos_trabajados > 0):
        print("¡Alerta! Has trabajado más de 8 horas seguidas.")

    return horas_trabajadas, minutos_trabajados
    
# Ejemplos de uso con los casos de prueba
entrada_1 = (8, 30)
salida_1 = (16, 45)
tiempo_trabajado_1 = calcular_tiempo_trabajado(entrada_1, salida_1)
print(f"Tiempo trabajado 1: {tiempo_trabajado_1[0]} horas {tiempo_trabajado_1[1]} minutos")

entrada_2 = (21, 45)
salida_2 = (5, 30)
tiempo_trabajado_2 = calcular_tiempo_trabajado(entrada_2, salida_2)
print(f"Tiempo trabajado 2: {tiempo_trabajado_2[0]} horas {tiempo_trabajado_2[1]} minutos")