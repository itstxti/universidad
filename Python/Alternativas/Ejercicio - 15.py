""" 15. Haz un subprograma que calcule cuantas de las piezas del Sistema Monetario de España
son múltiplos exactos del valor de una determinada, conocido su orden en la edición. 
Tomaremos ventaja de saber que los valores de las piezas están dados en orden descendente.

Ejemplo: Múltiplos de la cuarta (cuyo valor es 20.0) están, 500.0,200.0 y 100.0, por tanto, debe contestar 3 piezas."""



piezas = [1, 2, 5, 10, 20, 50, 100, 200, 500]

def contar_multiplos(lista, valor):
    # DEVUELVE CUANTOS VALORES DE UNA LISTA SON MULTIPLOS DE UN VALOR DETERMINADO.
    total = 0
    for i in lista:
        if i % valor == 0:
            total += 1
    return total

print(contar_multiplos(piezas, 50))