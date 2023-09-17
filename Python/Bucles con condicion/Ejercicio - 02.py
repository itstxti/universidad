""" 2. En 1674, Gregory propuso el siguiente algoritmo para calcular la raíz cuadrada de un número n>=0: 
El tipo de algoritmos que calculan un valor mediante iteraciones sucesivas a partir de una aproximación
fue generalizado en torno a 1700 por Newton-Raphson y este esquema de resolución de problemas recibe su nombre.
Haz un subprograma que calcule la raíz cuadrada de n, con una precisión mayor o igual que una determinada."""

def sqrtNR(n, precision):
    """ num,float-->float
    OBJ: raiz cuadrada de n, con precisión >= precision
    PRE: n>0, precision<n                                 """
    nAprox = n/2                    #vale cualquier positivo
    cambio = n              
    while cambio>=precision:
        aprox = nAprox
        nAprox = (aprox+n/aprox)/2.0
        cambio = abs(aprox-nAprox)
        
    return nAprox

print('raiz =', sqrtNR(9,0.1))