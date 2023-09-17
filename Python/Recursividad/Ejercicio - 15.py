""" 15.	Las torres de Hanoi es un rompecabezas inventado por el matemático francés Édouard Lucas en 1883.

Se dispone de 3 soportes y n discos de diferente radio.
Inicialmente los discos están apilados en orden creciente en el soporte O (origen).
Pasarlos al soporte D(destino), quedando en el mismo orden en que están actualmente.
El soporte T(temporal) puede servir de auxiliar. Sólo se puede mover un disco cada vez.
En cualquier soporte, en todo momento, cada disco debe tener un radio menor que el que tiene debajo."""

def pasar(num, origen, destino, temporal):
    if num == 1:
        print(f'Mover disco de la torre {origen} a la torre {destino}')
    else:
        pasar(num - 1, origen, temporal, destino)
        print(f'Mover disco de la torre {origen} a la torre {destino}')
        pasar(num - 1, temporal, destino, origen)

# PROGRAMA

n = int(input("Ingresa el número de discos: "))
pasar(n, 'A', 'C', 'B')