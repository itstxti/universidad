""" 8. Una fábrica funciona ininterrumpidamente (7días*24horas).
Se desea calcular el tiempo, expresado en horas y minutos, que ha trabajado un empleado,
sabiendo el momento de entrada y el de salida (expresados en horas y minutos).
Un trabajador no puede trabajar más de 8 horas seguidas, de modo que el momento de entrada y el de salida,
corresponden al mismo día (si entrada <= que la salida) o a días consecutivos (en caso contrario).
El programa indicará las horas y minutos trabajadas y caso de haber trabajado más de 8 horas, dará una alerta."""

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

    if supera_tiempo(horas_trabajadas, minutos_trabajados, 8, 0):
        print("¡Alerta! Has trabajado más de 8 horas seguidas.")

    return horas_trabajadas, minutos_trabajados


def supera_tiempo(hora, min, max_hora, max_min):
    if hora > max_hora or (hora == max_hora and min > max_min):
        return True
    return False

entrada_1 = (8, 30)
salida_1 = (16, 45)
tiempo_trabajado_1 = calcular_tiempo_trabajado(entrada_1, salida_1)
print(f"Tiempo trabajado 1: {tiempo_trabajado_1[0]} horas {tiempo_trabajado_1[1]} minutos")

entrada_2 = (21, 45)
salida_2 = (5, 30)
tiempo_trabajado_2 = calcular_tiempo_trabajado(entrada_2, salida_2)
print(f"Tiempo trabajado 2: {tiempo_trabajado_2[0]} horas {tiempo_trabajado_2[1]} minutos")