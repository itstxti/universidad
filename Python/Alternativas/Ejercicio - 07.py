""" 7. En el baremo para la adjudicación de plazas en las Escuelas Infantiles Públicas
se otorgan puntos en función de los ingresos de la unidad familiar, según se recoge en la siguiente tabla: 

1	5000	---
2	3500	5000
3	1800	3500
4	0	    1800

Construye un subprograma que devuelva a memoria los puntos de un niño según los ingresos de su unidad familiar.
Presta atención a la optimización."""

def puntos(n):
    if n>=5000:
        return 1
    if n>=3500:
        return 2
    if n >= 1800:
        return 3
    if n < 1800:
        return 4
    
print(puntos(5000))