"""Escribe un código que pide al vendedor el importe de una compra: Si la compra es
superior a 100EUR se aplica un descuento del 5% si se paga al contado, pero si el
pago es con tarjeta sólo se aplica el 2%. Asegúrate de que el importe de la compra
es un número válido antes de proceder a los cálculos (pista: usa try para
comprobar que es posible convertir la entrada a un float)."""

try:
    compra = float(input('Introduce el importe de la compra: '))
    metodo = int(input('Elige el metodo de pago: \n1. TARJETA \n2. EFECTIVO \n' ))

    if compra >= 100:
        if metodo == 1:
            descuento = 0.02
        if metodo == 2:
            descuento = 0.05
    else: descuento = 0
    total = compra - compra*descuento

except: print('HA HABIDO UN ERRROR.')
else: print('El total de tu compra es', total, '$.')