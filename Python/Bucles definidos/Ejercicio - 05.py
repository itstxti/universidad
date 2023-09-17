"""5. Los siguientes códigos, aunque hacen lo que se deseaba hacer, contienen errores conceptuales.
Corrígelos."""

#1 No crees un iterable (range) para recorrer una secuencia existente.

DIAS_SEMANA = ('L','M','X','J','V','S','D')
for DIA in DIAS_SEMANA:
    print(DIA)

#2 No toques los controles del bucle dentro de su cuerpo
# Es muy difícil de leer, de hecho, se comporta diferente en distintos lenguajes.

ini=0
fin=6
inc=2

for i in range (ini,fin,inc): 
    print(i, end= '\t')
    
print('\nEL INICIO ES', ini, '\nEL FINAL ES', fin, '\nEL INCREMENTO ES', inc)

#3 No toques el controlador del bucle dentro del bucle
# Es muy dificil de leer, de hecho, se comporta diferente en distintos lenguajes.

for i in range (6):
    print(i)

print('FIN')

#4 No uses el mismo controlador del bucle para bucles anidados.
# Es muy difícil de leer, de hecho, se comporta diferente en distintos lenguajes.

for i in range(10,30,10):
    print('b externo', i)
    for j in range(3):
        print(j)    
         
#5 Los “if controlador del bucle” en un “para todo” son sospechosos, revisa si son necesarios. 

for i in range(44):
    print('NÚMERO DE INTENTOS', i)