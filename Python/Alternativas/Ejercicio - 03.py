""" 3. Haz un subprograma que devuelve el número de días que tiene un mes (expresado en número) en un año no bisiesto.
Piensa primero cuantos casos de prueba necesitas.
Pero, en realidad, el año puede ser bisiesto ¿Cuántos parámetros necesitas ahora?
Rehaz el subprograma. Completa casos de prueba."""

dias_mes = [31, 28, 31, 30, 31, 30, 31, 31,30, 31, 30, 31]
meses = ['ENERO', 'FEBRERO', 'MARZO', 'ABRIL', 'MAYO', 'JUNIO', 'JULIO', 'AGOSTO', 'SEPTIEMBRE', 'OCTUBRE', 'NOVIEMBRE', 'DICIEMBRE']

def cuantos_dias(mes, bisiesto):
    for i in range(0, len(meses)):
        if mes.upper() == meses[i]:        
            if i == 1 and bisiesto:
                return dias_mes[i]+1
            else: return dias_mes[i]
    else:
        return 'ESTE MES NO VÁLIDO'

print('FEBRERO TIENE', cuantos_dias('febrero', False), 'EN UN AÑO NO BISIESTO')
print('ABRIL TIENE', cuantos_dias('ABRIL', False), 'EN UN AÑO NO BISIESTO')


print('FEBRERO TIENE', cuantos_dias('FEBRERO', False), 'EN UN AÑO BISIESTO')
print('MAYO TIENE', cuantos_dias('MAYO', False), 'EN UN AÑO BISIESTO')