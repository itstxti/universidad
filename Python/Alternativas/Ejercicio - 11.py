""" 11. El siguiente código devuelve cual es la estación del año.
Este código hace lo que tiene que hacer, pero tarda demasiado. SIN CAMBIAR la estructura de condicionales,
reescríbelo simplificándolo de forma que realice menos operaciones."""

def estacion (d,m):
    """int,intstr
    * devuelve estación que corresponde a d/m (dia/mes)               *
    *     20/03 al 19/06 Primavera   	                                       *
    *     20/06 al 21/09 Verano                                       *
    *     22/09 al 20/12 Otoño                                        *
    *     21/12 al 19/03 Invierno       
    PRE dia, mes formarían parte de una fecha válida"""               

    if (m==12 and d>=21) or m==1 or m==2 or (m==3 and d<=19):
        return 'INVIERNO'
    elif (m==3 and d>=20) or m==4 or m==5 or (m==6 and d<=19):
        return 'PRIMAVERA'
    elif (m==6 and d>=20) or m==7 or m==8 or (m==9 and d<=21):
        return 'VERANO'
    else: return 'OTOÑO'

print(estacion(1, 2))
print(estacion(5, 4))
print(estacion(20, 6))
print(estacion(31, 9))