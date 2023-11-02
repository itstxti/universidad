## Encuentra tres valores que tengan los tipos int, str y float.
## Comprueba con Python que sus valores son de los tipos pedidos.

v1 = 35
v2 = 'hola'
v3 = 4.9
v4 = 0.00000059

print(type(v1)) #int
print(type(v2)) #str
print(type(v3)) #float


# Escribe los datos en x espacios.

print('%6d%8s%8.1f%10.1e' % (v1, v2, v3, v4))

# Diferentes formas de usar print. Por defecto el separador es un espacio vacio.

print(v1, v2, v3, sep='')
print(v1, v2, v3, sep='$')
print(v1, v2, v3, sep='\n')
print('LAVA' + 'PLATOS')