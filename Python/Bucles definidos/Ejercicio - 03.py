""" 3. El factorial de un entero se representa como n!. Se define como:

0!=1; n!= 1*2*…*(n-1)*n para n>=1

Al aumentar n, el factorial de n aumenta muy rápidamente y tememos que desborde.
Escribe el código que permite calcular el factorial de un número en el rango de 0 a 30.
Recuerda que en combinatoria se emplea repetidamente esta función.
Seguir el orden propuesto en el dodecálogo de la programación te ayudará a obtener un buen código."""

def factorial(n):
    res = 1
    for i in range(1, n+1):
        res = res*i
    return res

print(factorial(3))
print(factorial(0))