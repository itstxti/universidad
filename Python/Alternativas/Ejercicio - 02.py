""" 2. Los siguientes códigos, aunque hacen lo que se deseaba hacer, contienen errores conceptuales.
Corrígelos y justifica tu propuesta (la PRE indica que ya está hecho antes y este subprograma o
porción de código no debe preocuparse de ello)."""

# 1 PRE: #0<=edad<=120

edad = 11

es_mayor_edad = edad >= 18

# 2 PRE: es_mayor_edad es bool

if es_mayor_edad:
    print('ENTRA A LA DISCOTECA.')
else:
    print ('NO ENTRA A LA DISCOTECA.')


# 3 PRE: 0<=n<=3

n = 2

if n==0: j=1
if n==1: j=2
if n==2: j=4
if n==3: j=8

print(j)

# 4 PRE x,y,z inicializados. and tiene prioridad sobre or en Python

x = 4
y = 4
z = 4

if x==y and x==z: print('los 3 son iguales')
if (x==y and y!=z) or (y==z and x!=y) or (x==z and x!=y):
      print('hay dos iguales')
if x!=y and x!=z and y!=z:
      print('ninguno igual')

# 5 el subprograma contiene PRE: 0<=edad<=120

if edad<=13: print('NIÑO')
elif edad<18: print('ADOLESCENTE')
elif edad<=120: print('ADULTO')

#6

try:
    nombre = input('INTRODUCE SU NOMBRE: ')
    print('SU NOMBRE ES', nombre.upper())
except: print('EL NOMBRE NO ES VÁLIDO.')

#7

try:
    n = int(input('INTRODUCE UN NÚMERO ENTERO EN CIFRAS: '))
    print('EL NÚMERO INTRODUCIDO ES', n)
except: print('EL NÚMERO INTRODUCIDO NO ES VÁLIDO.')

#8 i previamente está inicializado a algún entero. Mucha redundancia en el código. Saca “factor común”

i = 1

print ('SEC DE INSTRUCCIONES A')

if i==1:
    i+=4
else:
    i+=2

print(i)